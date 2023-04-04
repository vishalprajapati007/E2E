import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Products {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
		int j=0;
		
		String[] itemlist = {"Mushroom","Potato","Tomato"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(3000);
		
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
