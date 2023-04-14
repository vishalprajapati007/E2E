import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class calenderUi {

	public static void main(String[] args) throws InterruptedException {
		
         ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
	
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.path2usa.com/travel-companion/");
		
		System.out.println(driver.getTitle());
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,1100)");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[id*='form-field-travel_comp_date']")).click();		
		
		while(!driver.findElement(By.cssSelector("div[class*='flatpickr-month']")).getText().contains("July"))
		{
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}
		
		List<WebElement> date = driver.findElements(By.className("flatpickr-day"));
		
	     int con = driver.findElements(By.className("flatpickr-day")).size();
		
		for(int i=0; i<con; i++)
		{
						
			String test= driver.findElements(By.className("flatpickr-day")).get(i).getText();
			
			if(test.equalsIgnoreCase("29"))
			{
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				
				break;
			}
		}
		System.out.println(driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value"));
	}
	
	}


