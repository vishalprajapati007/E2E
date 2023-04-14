import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException{
		
		ChromeOptions option= new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
				
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		
		//Thread.sleep(2000);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(5000));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		//ExpectedConditions
		driver.findElement(By.id("okayBtn")).click();
		WebElement options1 =  driver.findElement(By.xpath("//select[@class='form-control']"));
		
		Select dropdown = new Select(options1);
		
		dropdown.selectByValue("consult");
		
		driver.findElement(By.xpath("//option[@value='consult']")).click();
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
		//Thread.sleep(3000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-footer .btn-info")));
		
		
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		
		for(int i=0; i<products.size(); i++)
		{
			products.get(i).click();
							
			}
		w.until(ExpectedConditions . elementToBeClickable (By.xpath("(//a[@class='nav-link btn btn-primary'])[1]")));
		driver.findElement(By.xpath("(//a[@class='nav-link btn btn-primary'])[1]")).click();
		}
		

		
		
		

}

