import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException{

        ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
	
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		
		String VP = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		
	    WebElement D= driver.findElement(By.id("dropdown-class-example"));
	    
	     Select s = new Select(D);
	     s.selectByVisibleText(VP);
	     Thread.sleep(2000);
	     
	     driver.findElement(By.id("name")).sendKeys(VP);
	     
	     driver.findElement(By.id("alertbtn")).click();
	     
	     String test= driver.switchTo().alert().getText();
	     
	     if(test.contains(VP))
	     {
	    	 System.out.println("Success");
	     }
	     else
	     {
	    	 System.out.println("Error");
	     }
	   

	}

}
