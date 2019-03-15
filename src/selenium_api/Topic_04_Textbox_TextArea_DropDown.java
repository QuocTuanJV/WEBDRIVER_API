package selenium_api;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_04_Textbox_TextArea_DropDown {

	WebDriver driver;

	// XPATH Element input
	By nameCustomerTextbox = By.xpath("//input[@name='name']");
	By genderMaleRadioButton = By.xpath("//input[@type = 'radio' and @value='m']");
	By genderFemaleRadioButton = By.xpath("//input[@type = 'radio' and @value='f']");
	By dateOfbirth = By.xpath("//input[@name='dob']");
	By addressTextArea = By.xpath("//textarea[@name='addr']");
	By cityTextbox = By.xpath("//input[@name='city']");
	By stateTextbox = By.xpath("//input[@name='state']");
	By pinTextbox = By.xpath("//input[@name='pinno']");
	By mobileNumberTextbox = By.xpath("//input[@name='telephoneno']");
	By emailTextbox = By.xpath("//input[@name='emailid']");
	By passwordTexbox = By.xpath("//input[@name='password']");
	By submitButton = By.xpath("//input[@value='Submit and @name='sub'']");

	// XPATH Element output

	By outNameCustomerTextbox = By.xpath("//td[contains(text(),'Customer Name')]/following-sibling::td");
	By outGenderRadioButton = By.xpath("//td[contains(text(),'Gender')]/following-sibling::td");
	By outDateOfbirth = By.xpath("//td[contains(text(),'Birthdate')]/following-sibling::td");
	By outAddressTextArea = By.xpath("//td[contains(text(),'Address')]/following-sibling::td");
	By outCityTextbox = By.xpath("//td[contains(text(),'City')]/following-sibling::td");
	By outStateTextbox = By.xpath("//td[contains(text(),'State')]/following-sibling::td");
	By outPinTextbox = By.xpath("//td[contains(text(),'Pin')]/following-sibling::td");
	By outMobileNumberTextbox = By.xpath("//td[contains(text(),'Mobile No.')]/following-sibling::td");
	By outEmailTextbox = By.xpath("//td[contains(text(),'Email')]/following-sibling::td");

	// XPATH LABEL

	By labelNameCustomerTextbox = By.xpath("//td[contains(text(),'Customer Name')]");
	By labelGenderRadioButton = By.xpath("//td[contains(text(),'Gender')]");
	By labelDateOfbirth = By.xpath("//td[contains(text(),'Birthdate')]");
	By labelAddressTextArea = By.xpath("//td[contains(text(),'Address')]");
	By labelCityTextbox = By.xpath("//td[contains(text(),'City')]");
	By labelStateTextbox = By.xpath("//td[contains(text(),'State')]");
	By labelPinTextbox = By.xpath("//td[contains(text(),'Pin')]");
	By labelMobileNumberTextbox = By.xpath("//td[contains(text(),'Mobile No.')]");
	By labelEmailTextbox = By.xpath("//td[contains(text(),'Email')]");

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
	public void TC_01_Handle_Textbox_TextArea() {
		// Step 01: Access URL http://demo.guru99.com/v4
		driver.get("http://demo.guru99.com/v4");

		// Step 02: Login with USer: mngr184486 and Password: pezatUv

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr184486");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("pezatUv");

		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

		String homepageWelcome = driver.findElement(By.xpath("//marquee[@class='heading3' ]")).getText();

//	  Assert.assertTrue("Welcome To Manager's Page of Guru99 Bank".equals(homepageWelcome));

		Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", homepageWelcome);

		System.out.println("----HOME PAGE IS DISPLAYED SUCCESS----");

		// Step 03: Select menu New Customer

		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();

		// Step 04: Fill data correct
		// Customer Name
		driver.findElement(nameCustomerTextbox).sendKeys("Selenium Online");

		// Gender
		driver.findElement(genderFemaleRadioButton).click();

		// Date of Birth
		driver.findElement(dateOfbirth).sendKeys("01-08-1992");

		// Address
		driver.findElement(addressTextArea).sendKeys("123 Address");

		// City
		driver.findElement(cityTextbox).sendKeys("Ho Chi Minh");

		// State
		driver.findElement(stateTextbox).sendKeys("Thu Duc");

		// PIN
		driver.findElement(pinTextbox).sendKeys("123456");

		// Mobile Number
		driver.findElement(mobileNumberTextbox).sendKeys("0123456987");

		// Email
		
		String emailRandom = "TUAN"+ randomID() + "@gmail.com";
		driver.findElement(emailTextbox).sendKeys(emailRandom);

		// Password
		driver.findElement(passwordTexbox).sendKeys("123456");

		// Click submit
		driver.findElement(submitButton).click();

		// Step 05: Get id Customer
		String idCustomer = driver.findElement(By.xpath("//td[contains(text(), 'Customer ID')]/following-sibling::td"))
				.getText();
		System.out.println("----------------------------------");
		System.out.println("---CUSTOMER ID IS: " + idCustomer);
		System.out.println("----------------------------------");
		
		// Step 06: Verify information 
		Assert.assertTrue(isTheSame("Selenium Online", outNameCustomerTextbox, labelNameCustomerTextbox));
		
		//Gender
		Assert.assertTrue(isTheSame("female", outGenderRadioButton, labelGenderRadioButton));// female
		
		//Birth day
		Assert.assertTrue(condition);
		
		//Email
		Assert.assertTrue(isTheSame(emailRandom, outEmailTextbox, labelEmailTextbox));

		

	}

	@AfterClass
	public void afterClass() {
		
	}

	public boolean isTheSame(String expected, By byOut, By byLabel) {

		if (expected.equals(driver.findElement(byOut).getText())) {
			System.out.println("INFOMATION " + getLabel(byLabel) + ": IS VERIFY");
			return true;	
		}
		else
		{
			System.out.println("INFOMATION " + getLabel(byLabel) + ": IS NOT VERIFY");
			return false;
		}
	}

	public String getLabel(By byLabel) {
		return driver.findElement(byLabel).getText();
	}
	
	public int randomID() {
		Random rd = new Random();
		return rd.nextInt(1000);
	}

}
