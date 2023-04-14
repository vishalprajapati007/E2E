import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Assignment5 {

	public static void main(String[] args) throws InterruptedException{
		
        ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
	
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame(0);
		
		driver.switchTo().frame("frame-middle");		
	
	    System.out.println(driver.findElement(By.id("content")).getText());

	}

}
