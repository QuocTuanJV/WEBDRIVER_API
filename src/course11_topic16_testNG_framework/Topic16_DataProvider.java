package course11_topic16_testNG_framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic16_DataProvider {
	
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "UserAndPassword")
	public void f(String email, String password) {
		//Click to navigate to login form
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed());
		
		
		//logout
		driver.findElement(By.xpath("//div[@class='page-header-container']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		//
		
		
		
		
		
	}

	@DataProvider
	public Object[][] UserAndPassword() {
		return new Object[][] { 
			new Object[] { "LUONGTUAN123@GMAIL.COM", "010892" }, 
			new Object[] { "LUONGTUAN1234@GMAIL.COM", "010892" },
			};
	}

	@AfterClass
	public void afterClass() {
	}

}
