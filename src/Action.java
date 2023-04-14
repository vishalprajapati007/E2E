import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver= new ChromeDriver(option);
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
        Actions a = new Actions(driver);
        
        WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        
        Thread.sleep(2000);
        
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick();
        
        a.moveToElement(move).contextClick().build().perform();
        
      
	}
	
}
