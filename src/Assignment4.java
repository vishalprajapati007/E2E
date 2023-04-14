import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException{
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		
		driver.get("https://the-internet.herokuapp.com/");
		
		//Thread.sleep(2000);
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String> window= driver.getWindowHandles();
		Iterator<String> it=   window.iterator();
		String ParentID=  it.next();
		String ChildID =  it.next();
		driver.switchTo().window(ChildID);
		//Thread.sleep(2000);
	    System.out.println(driver.findElement(By.xpath("//h3[.='New Window']")).getText());
	    driver.switchTo().window(ParentID);
	    System.out.println(driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText());

	}

}
