import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class e2e {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();

		option.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(option);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().window().maximize();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.cssSelector("a[value='BHO']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='UDR']"))
				.click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000);

		for (int i = 1; i < 5; i++) {

			driver.findElement(By.id("hrefIncAdt")).click();

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(3000);

		List<WebElement> option1 = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		for (WebElement test : option1) {
			if (test.getText().equalsIgnoreCase("india")) {
				test.click();
				break;
			}
		}

		WebElement Statice = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(Statice);

		dropdown.selectByValue("USD");

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}
}
