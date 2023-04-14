import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Windowhandal {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
       Set<String> window = driver.getWindowHandles();
       Iterator<String> it= window.iterator();
       String ParanetID =it.next();
       String ChildID=it.next();
       driver.switchTo().window(ChildID);
       System.out.println( driver.findElement(By.cssSelector("p[class*='im-para red']")).getText());
       String Emailid= driver.findElement(By.cssSelector("p[class*='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
       driver.switchTo().window(ParanetID);
       driver.findElement(By.id("username")).sendKeys(Emailid);
	}

}
