package course9_topic13_uploadfile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Uploadfile {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//			driver = new ChromeDriver();

		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
	}

	@AfterClass
	public void afterClass() {
	}

}
