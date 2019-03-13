package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_03_Webbrowser_WebElement {

	WebDriver driver;
	
	//Enable Element
	By emailByTextbox = By.xpath("//input[@type = 'email']");
	By radioByButton = By.xpath("//input[@id = 'under_18']");
	By educationByTextbox = By.xpath("//*[@name='user_edu']");
	By jobRole01 = By.xpath("//select[@id='job1']");
	By developmentCheckbox = By.xpath("//input[@value = 'interest_development']");
	By slider01 = By.xpath("//input[@name = 'slider-1']");
	By buttonEnable = By.xpath("//button[@id='button-enabled']");
	
	//Disable Element
	By passwordByTextbox = By.xpath("//input[@id ='password']");
	By radiobuttonDisable = By.xpath("//input[@id = 'radio-disabled']");
	By biographyArea = By.xpath("//textarea[@name = 'user_bio']");
	By jobRole02 = By.xpath("//select[@name ='user_job2']");
	By interestsCheckboxDisable = By.xpath("//input[@id ='check-disbaled']");
	By slider02 = By.xpath("//input[@id = 'slider-2']");
	By buttonDisable = By.xpath("//button[@id = 'button-disabled']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

//		driver = new FirefoxDriver();

		driver.get("https://daominhdam.github.io/basic-form/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_CheckDisplayElement() {
		// Step 01: Access Page
		driver.get("https://daominhdam.github.io/basic-form/index.html");

		// Step 02: Check display Element

		// -------------------WAY 01 MANUAL-------------
		// ---------------------------------------------

		// --------Email text area

//		if(driver.findElement(emailByTextbox).isDisplayed()) {
//			System.out.println("ELEMENT "+ emailByTextbox + " is display");
//			driver.findElement(emailByTextbox).sendKeys("Automation Testing");
//		}
//		else {
//			System.out.println("ELEMENT "+ emailByTextbox + " is not display");
//		}
//		
//		//--------Education text area
//		if(driver.findElement(educationByTextbox).isDisplayed()) {
//			System.out.println("ELEMENT "+ emailByTextbox + " is display");
//			driver.findElement(educationByTextbox).sendKeys("Automation Testing");
//		}
//		else {
//			System.out.println("ELEMENT "+ emailByTextbox + " is not display");
//		}
//		//---------Age radio button
//		
//		if(driver.findElement(radioByButton).isDisplayed()) {
//			System.out.println("ELEMENT "+ radioByButton + " is display");
//			driver.findElement(radioByButton).click();
//		}
//		else {
//			System.out.println("ELEMENT "+ radioByButton + " is not display");
//		}

		// -------------------WAY 02 USE FUNCTION-------------
		// ---------------------------------------------------
		if (isElementDisplay(emailByTextbox)) {
			driver.findElement(emailByTextbox).sendKeys("Automation Testing");
		}

		if (isElementDisplay(educationByTextbox)) {
			driver.findElement(educationByTextbox).sendKeys("Automation Testing");
		}

		if (isElementDisplay(radioByButton)) {
			driver.findElement(radioByButton).click();
		}

//		boolean isDisplayEmail = driver.findElement(By.xpath("//input[@type = 'email']")).isEnabled();
//		Assert.assertTrue(isDisplayEmail);
//		
//		boolean isDisplayAge = driver.findElement(By.xpath("//input[@id = 'under_18']")).isEnabled();
//		Assert.assertTrue(isDisplayAge);

	}

	@Test
	public void TC_02_CheckElementEnableDisable() {
		// Step 01: Access URL
		driver.get("https://daominhdam.github.io/basic-form/index.html");

		// Step 02: Check Enable Element
		System.out.println("----------CHECK ENABLE---------");
		isElementEnable(emailByTextbox);
		isElementEnable(radioByButton);
		isElementEnable(educationByTextbox);
		isElementEnable(jobRole01);
		isElementEnable(developmentCheckbox);
		isElementEnable(slider01);
		isElementEnable(buttonEnable);
		
		// Step 03: Check disable Element
		System.out.println("----------CHECK DISABLE---------");
		isElementEnable(passwordByTextbox);
		isElementEnable(radiobuttonDisable);
		isElementEnable(biographyArea);
		isElementEnable(jobRole02);
		isElementEnable(interestsCheckboxDisable);
		isElementEnable(slider02);
		isElementEnable(buttonDisable);
		
	}
	
	@Test
	public void TC_03_CheckElementOnPage() {
		//Step 01: Access URL
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		
		// Step 02: Select Age (Under 18) and Interests (Development)
		driver.findElement(radioByButton).click();
		driver.findElement(developmentCheckbox).click();
		
		// Step 03: Check Element is selected on Step 02
		System.out.println("-------------------------");
		System.out.println("Check element is selected");
		Assert.assertTrue(isElementSelected(radioByButton));
		Assert.assertTrue(isElementSelected(developmentCheckbox));
//		isElementSelected(radioByButton);
//		isElementSelected(developmentCheckbox);
		
		// Step 04: Click to un-check Interest (Development) check-box
		driver.findElement(developmentCheckbox).click();
		System.out.println("-------------------------");
		System.out.println("RE-CHECK ELEMENT");
//		isElementSelected(radioByButton);
//		isElementSelected(developmentCheckbox);
		Assert.assertTrue(isElementSelected(radioByButton));
		Assert.assertFalse(isElementSelected(developmentCheckbox));
		
		//Step 05: if uncheck -> check
		if(isElementSelected(developmentCheckbox)==false) {
			driver.findElement(developmentCheckbox).click();
		}
		
		Assert.assertTrue(isElementSelected(developmentCheckbox));
		
	}
	
//	System.out.println("----------REPORT TEST CASE FALSE/PASS---------");

	@AfterClass
	public void afterClass() {
	}

	public boolean isElementDisplay(By by) {
		WebElement wb = driver.findElement(by);
		
		if (wb.isDisplayed()) {
			System.out.println("ELEMENT " + by + " IS DISPLAYED");
			return true;
		} else {
			System.out.println("ELEMENT " + by + " IS NOT DISPLAYED");
			return false;

		}

	}

	public boolean isElementEnable(By by) {
		WebElement wb = driver.findElement(by);
		if (wb.isEnabled()) {
			System.out.println("ELEMENT [ " + by + " ] IS ENABLED");
			return true;
		} else {
			System.out.println("ELEMENT [" + by + " ] IS DISABLED");
			return false;

		}

	}

	public boolean isElementSelected(By by) {
		WebElement wb = driver.findElement(by);
		if (wb.isSelected()) {
			System.out.println("ELEMENT [" + by + " ] IS SELECTED");
			return true;
		} else {
			System.out.println("ELEMENT [" + by + " ] IS NOT SELECTED");
			return false;
		}
	}

}
