package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_05_Handle_Dropdown_List {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

//		driver = new FirefoxDriver();

		// driver.get("");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Handle_HTML_DropDownlist() {
		//Go to  Link
		//Step 01:
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		
		//Step 02: Check drop down Job Role 01 not support attribute multi - select
		
		Select  select = new Select("");
		
		
		
		
		
		
	}

	@AfterClass
	public void afterClass() {
	}

}
