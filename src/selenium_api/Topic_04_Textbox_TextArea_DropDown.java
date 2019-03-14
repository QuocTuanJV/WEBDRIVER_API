package selenium_api;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_04_Textbox_TextArea_DropDown {
	
	WebDriver driver;
	
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
	
	
	

  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

//		driver = new FirefoxDriver();

		//driver.get("");
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
	  //Customer Name
	  driver.findElement(nameCustomerTextbox).sendKeys("Selenium Online");
	  
	  //Gender
	  driver.findElement(genderFemaleRadioButton).click();
	  
	  // Date of Birth
	  driver.findElement(dateOfbirth).sendKeys("01081992");
	  
	  //Address
	  driver.findElement(addressTextArea).sendKeys("123 Address");
	  
	  //City
	  driver.findElement(cityTextbox).sendKeys("Ho Chi Minh");
	  
	  //State
	  driver.findElement(stateTextbox).sendKeys("Thu Duc");
	  
	  //PIN
	  driver.findElement(pinTextbox).sendKeys("123456");
	  
	  //Mobile Number
	  driver.findElement(mobileNumberTextbox).sendKeys("0123456987");
	  
	  //Email
	  driver.findElement(emailTextbox).sendKeys("TUAN123@gmail.com");
	  
	  //Password
	  driver.findElement(passwordTexbox).sendKeys("123456");
	  
	  // Click submit
	  driver.findElement(submitButton).click();
	  
	  // Step 05: 
	  
	  
	  
	  
	  
	 
  }

  @AfterClass
  public void afterClass() {
  }

}
