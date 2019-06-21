package course10_Topic14_WebdriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@Test
	public void TC_02_ExplicitWait() {
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		
	}

	@AfterClass
	public void afterClass() {
	}

}
