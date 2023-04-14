import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Demotest {

	public static void main(String[] args) throws InterruptedException {
		
        ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
	
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

}
