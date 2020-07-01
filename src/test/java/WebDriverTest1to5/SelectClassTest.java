package WebDriverTest1to5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassTest {

	static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.out.println("Launching the chrome browser!");

		/**
		 * Launching the Chrome browser using the BoniGarcia - dependency otherwise
		 * We need to set System propery!
		 * */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void selectclass() {
		/**
		 * Finding the drop-down web element then pass into select class constructor!
		 * */
		WebElement opt = driver.findElement(By.id("divpaxinfo"));
		opt.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement pax_dropdown = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		pax_dropdown.click();
		
		Select sel = new Select(pax_dropdown);
		
		List<WebElement> webele = sel.getOptions();
		
		for(WebElement options : webele) {
			System.out.println("Option: "  +options.getText());
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
