import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Badssl {

	public static void main(String[] args) throws InterruptedException {
		
		    ChromeOptions option = new ChromeOptions();
			
			option.addArguments("--remote-allow-origins=*");
            option.setAcceptInsecureCerts(true);
            
            Proxy proxy = new Proxy();

            proxy.setHttpProxy("ipaddress:4444");

            option.setCapability("proxy", proxy);

            Map<String, Object> prefs = new HashMap<String, Object>();



            prefs.put("download.default_directory", "/directory/path");



            option.setExperimentalOption("prefs", prefs);
            
		    
//		    FirefoxOptions fx = new FirefoxOptions();
//		    
//		    fx.setAcceptInsecureCerts(true);
//		    
//		    WebDriver driver = new FirefoxDriver(fx);
		    
			WebDriver driver = new ChromeDriver(option);
			
			driver.get("https://expired.badssl.com/");
			
			System.out.println(driver.getTitle());

	}

}
