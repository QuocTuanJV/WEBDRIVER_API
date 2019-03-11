package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
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

		// Step 01: Open link URL
		driver.get("http://live.guru99.com");

		String homePageTitle = driver.getTitle();

		// Step 02: check title Home page
		Assert.assertEquals(homePageTitle, "Home page");
//		Assert.assertTrue(homePageTitle == "Home page");
//		Assert.assertTrue(homePageTitle.equals("Home page"));

		// Step 03: Click link "My Account"
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// Step 04: Create a Account
		driver.findElement(By.xpath("//span[text() = 'Create an Account']")).click();

		// Step 05: Back to login page
		driver.navigate().back();

		// Step 06: Check url page login is:
		// http://live.guru99.com/index.php/customer/account/login/
		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginUrl, "http://live.guru99.com/index.php/customer/account/login/");

		// Step 07: Forward to create account
		driver.navigate().forward();

		// Step 08: Check url page create account:
		// http://live.guru99.com/index.php/customer/account/create/
		String createAnAccountUrl = driver.getCurrentUrl();
		Assert.assertEquals(createAnAccountUrl, "http://live.guru99.com/index.php/customer/account/create/");

	}

	@Test
	public void TC_02_EmailAndPasswordEmpty() {
		// Step 01: Go to link URL
		driver.get("http://live.guru99.com");

		// driver.get("https://www.google.com/");

		// Step 02: Click link "My Account"
		driver.findElement(By.xpath("//div[@class ='footer']//a[@title='My Account']")).click();
//		driver.findElement(By.xpath("//div[@class ='footer']//a[contains(text(),'My Account')]")).click();
//		driver.findElement(By.xpath("//div[@class ='footer']//a[text()='My Account']")).click();

		// Step 03: Input blank for UserName/Password
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");

		// Step 04: Click button Login
		// //div[@class='buttons-set']//span[contains(text(),'Login')]
		driver.findElement(By.xpath("//div[@class='buttons-set']//span[contains(text(),'Login')]")).click();

		// Step 05: Verify text fill

		String emailErrorMessage = driver.findElement(By.xpath(" //div[@id='advice-required-entry-email']")).getText();
		String passErrorMessage = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();

		System.out.println("TWO VERIYFOUND IS:  " + emailErrorMessage + " " + passErrorMessage);

		Assert.assertEquals(emailErrorMessage, "This is a required field.");
		Assert.assertEquals(passErrorMessage, "This is a required field.");
	}

	@Test
	public void TC_06_RegisterToSystem() {
		// Step 01: Access URL
		driver.get("http://live.guru99.com/");

		// Step 02: Click link "My Account"
		driver.findElement(By.xpath("//div[@class ='footer']//a[@title ='My Account']")).click();
//		driver.findElement(By.xpath("//div[@class ='footer']//a[text() ='My Account']")).click();
//		driver.findElement(By.xpath("//div[@class ='footer']//a[contains(text(),'My Account')]")).click();

		// Step 03: Click CREATE AN ACCOUNT button
		driver.findElement(By.xpath("//span[contains(text(), 'Create an Account')]")).click();
//		driver.findElement(By.xpath("//span[text() = 'Create an Account']")).click();

		// Step 04: Fill data register
		// First Name
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Luong");

		// Last Name
		driver.findElement(By.xpath("//input[@id = 'lastname']")).sendKeys("Tuan");

		// RANDOM_EMAIL
		Random rd = new Random();
		int number = rd.nextInt(1000);
		String randomEmail = "TUAN" + Integer.toString(number) + "@gmail.com";

		// Email
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(randomEmail);

		System.out.println("EMAIL IS: " + randomEmail);

		// Password
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("123456");

		// Confirm Password
		driver.findElement(By.xpath("//input[@id ='confirmation']")).sendKeys("123456");

		// Step 05: click button
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();

		// Step 5_01: Verify Message register success: Thank you for registering with
		// Main Website Store

		String registerSuccessMessage = driver
				.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]"))
				.getText();

		Assert.assertEquals(registerSuccessMessage, "Thank you for registering with Main Website Store.");

		System.out.println("--------Register success--------");

		// Step 06: Logout

		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();

		driver.findElement(By.xpath("//a[@title='Log Out']")).click();

		System.out.println("--------Logout success--------");

		// Step 06_01: navigate homepage success
		boolean homepageSuccess = driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for ')]"))
				.isDisplayed();
		Assert.assertTrue(homepageSuccess);

		System.out.println("-----HOME PAGE IS BACK------");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
