package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath {
	
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://live.guru99.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS );
		
	}

	@Test
	public void TC_01_CheckTitle() {
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
