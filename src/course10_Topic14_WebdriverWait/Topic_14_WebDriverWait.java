package course10_Topic14_WebdriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_WebDriverWait {

	WebDriver driver;
	WebDriverWait waitExplicit;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		waitExplicit = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_ImplicitWait() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[text()='Start']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());

	}

//	@Test
	public void TC_02_ExplicitWait() {
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

	}

	@Test
	public void TC_03_Visible_Presence() {

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// check visible button click
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Start']")));
		System.out.println("VISIBLE BUTTON CLICK");

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		// presence
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='loading']")));
		System.out.println("PRESENCE");

//		// visible
//		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='loading']")));
//		System.out.println("VISIBLE");
//		
		// check invisible loading or display HelloWorld
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
		System.out.println("INVISIBLE LOADING....");
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Start']")));
		System.out.println("VISIBLE HELLO WORLD");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());

	}
	
	@Test
	public void TC_04_Visible_Presence() {
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// check visible button click
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Start']")));
		System.out.println("VISIBLE BUTTON CLICK");
		
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		// presence
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='loading']")));
		System.out.println("PRESENCE");
		
//		// visible
//		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='loading']")));
//		System.out.println("VISIBLE");
//		
		// check invisible loading or display HelloWorld
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
		System.out.println("INVISIBLE LOADING....");
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Start']")));
		System.out.println("VISIBLE HELLO WORLD");
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
	}

}
