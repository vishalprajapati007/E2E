import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class openconnection404 {

	public static void main(String[] args)throws InterruptedException, MalformedURLException, IOException{
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
	
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		 List<WebElement> link= driver.findElements(By.cssSelector("li[class*='gf-li'] a"));
		 
		 SoftAssert a = new SoftAssert();
		 
		 for(WebElement urls : link)
		 {
			 String url=  urls.getAttribute("href");
			 
			 HttpURLConnection abc = (HttpURLConnection)new URL(url).openConnection();
			    
			 abc.setRequestMethod("HEAD");
			 abc.connect();
			 int resCod= abc.getResponseCode();
			    
			 System.out.println(resCod);
			 
			 a.assertEquals(resCod<400, "broken links"+ urls.getText()+"is here"+ resCod);
		 }
		
		a.assertAll();
		
		
		
		
	    
	  
	    
	  

	}

}
