import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException{
		  
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
	
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		System.out.println( driver.findElements(By.cssSelector(".table-display tr")).size());
		
	    System.out.println(driver.findElements(By.cssSelector(".table-display tr:nth-child(2) td")).size());
		
		List<WebElement> count= driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));
		
    	for(int i=0; i<count.size();i++)
		{
		    System.out.println(count.get(i).getText());
		}

	}

}
