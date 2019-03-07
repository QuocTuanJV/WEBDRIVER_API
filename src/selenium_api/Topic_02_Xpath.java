package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_CheckUrlAndTitle() {	
		String homePageTitle = driver.getTitle();
		
		//Step 02: check title Home page
		Assert.assertEquals(homePageTitle, "Home page");
//		Assert.assertTrue(homePageTitle == "Home page");
//		Assert.assertTrue(homePageTitle.equals("Home page"));
		
		//Step 03: Click link "My Account"
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		//Step 04: Create a Account
		driver.findElement(By.xpath("//span[text() = 'Create an Account']")).click();
		
		//Step 05: Back to login page
		driver.navigate().back();
		
		//Step 06: Check url page login is: http://live.guru99.com/index.php/customer/account/login/
		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginUrl,"http://live.guru99.com/index.php/customer/account/login/");
		
		//Step 07: Forward to create account
		driver.navigate().forward();
		
		//Step 08: Check url page create account: http://live.guru99.com/index.php/customer/account/create/
		String createAnAccountUrl = driver.getCurrentUrl();
		Assert.assertEquals(createAnAccountUrl, "http://live.guru99.com/index.php/customer/account/create/");
		
		
		
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
