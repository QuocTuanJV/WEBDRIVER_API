package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_03_Webbrowser_WebElement {

	WebDriver driver;
	
	By emailByTextbox = By.xpath("//input[@type = 'email']");
	By radioByButton = By.xpath("//input[@id = 'under_18']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://daominhdam.github.io/basic-form/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_CheckDisplayElement(){    
		//Step 01: Access Page
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		
		//Step 02: Check display Element
		
		if(driver.findElement(emailByTextbox).isDisplayed()) {
			System.out.println("ELEMENT "+ emailByTextbox + " is display");
		}
		else {
			System.out.println("ELEMENT "+ emailByTextbox + " is not display");
		}
		
		
		if(driver.findElement(radioByButton).isDisplayed()) {
			System.out.println("ELEMENT "+ radioByButton + " is display");
		}
		else {
			System.out.println("ELEMENT "+ radioByButton + " is not display");
		}
			
		
//		boolean isDisplayEmail = driver.findElement(By.xpath("//input[@type = 'email']")).isEnabled();
//		Assert.assertTrue(isDisplayEmail);
//		
//		boolean isDisplayAge = driver.findElement(By.xpath("//input[@id = 'under_18']")).isEnabled();
//		Assert.assertTrue(isDisplayAge);
		
		
		
	}

	@AfterClass
	public void afterClass() {
	}
	
//	public boolean isElementDisplay(By by) {
//		WebElement wb = driver.findElement(by);
//		if(wb.isDisplayed()) {
//			System.out.println("ELEMENT " + by + " IS DISPLAY");
//			return true;
//		}
//		else
//		{
//			System.out.println("ELEMENT " + by + " IS NOT DISPLAY");
//			return false;
//			
//		}
//		
//	}

}
