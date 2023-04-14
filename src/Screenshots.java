import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Screenshots {

	public static void main(String[] args) throws InterruptedException, IOException{
		
	        ChromeOptions option = new ChromeOptions();
		
			option.addArguments("--remote-allow-origins=*");
		
			WebDriver driver = new ChromeDriver(option);
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(src, new File("D:\\screen\\A1.png"));
			
	}

}
