import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		
        ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
        
		String[] itemlist = {"Mushroom","Potato","Tomato"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(3000);
		
	   	additem(driver,itemlist);	
	   	
	   	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	   	driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']")).click();
	   	driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
	   	driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
	   	
	   	//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
	    System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
	
		
	}

	private static void additem(WebDriver driver, String[] itemlist) {
		
		int j=0;
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<items.size();i++)
		{
			//Potato - 1 Kg
			
			String[] name = items.get(i).getText().split("-");
			String test = name[0].trim();
			
			List listofitem = Arrays.asList(itemlist);
			
			if(listofitem.contains(test))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemlist.length)
				{
					break;
				}
			}
		}
	}

}
