package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_05_Button_Radio_Checkbox_Alert {
	WebDriver driver;
	WebDriverWait waitExplicit;
	
	JavascriptExecutor javaExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		waitExplicit = new WebDriverWait(driver, 30);
		
		javaExecutor = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//	@Test
//	public void TC_01_HandleButton() {
//		// get page
//		driver.get("http://live.guru99.com/");
//		
//		//Click My Account on footer
//		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
//		
//		//Click on Create an Account use JavascriptExecutor
//		
//		WebElement wb = driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]"));
//		clickElementByJavascript(driver, wb);
//		
//		//Check URL
//		
//		Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/create/");
//		System.out.println("CHECK URL SUCCESSED!!!!!!!!!!!");
//
//		
//	}
//	@Test
//	public void TC_02_HandleCheckbox() throws InterruptedException {
//		//get page
//		driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
//		
//		//Click checkbox
//		driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]")).click();
//		
//		//Check checkbox is selected
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).isSelected());
//		
//		System.out.println("CHECBOX IS SELECTED!!!!!");
//		
//		Thread.sleep(300);
//		
//		driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]")).click();
//		
//		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).isSelected());
//		
//		System.out.println("CHECBOX IS NOT SELECTED!!!!!");
//		
//		//
//
//		
//	}
	
//	@Test
//	public void TC_03_HandleCheckbox3() throws InterruptedException {
//		//get page
//		driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
//		//Way 2 JavascriptExecutor
//		//Selected
//		clickElementByJavascript(driver, driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")));
//		
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected());
//		
//		
//		Thread.sleep(300);
//		
//		//unselected
//		if(driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected())	
//		{
//		clickElementByJavascript(driver, driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")));
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected());
//		System.out.println("RADIO BUTTON IS SELECTED!!!!");
//		}
//		else
//		
////		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected());
//		System.out.println("RADIO BUTTON IS UNSELECTED!!!!");
//		
//	
//	}
	
//	@Test
//	public void TC_05_Alert_Accept() {
//		driver.get("https://daominhdam.github.io/basic-form/index.html");
//		By resultMessage = By.xpath("//p[@id = 'result']");
//		
//		// click to Alert
//		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
//		
//		Alert alert = driver.switchTo().alert();
//		
//		//Get Alert Message
//		String alertMessage = alert.getText();
//		
//		//Verify Alert Message
//		Assert.assertEquals(alertMessage, "I am a JS Alert");
//		
//		//Click OK on Alert popup
//		alert.accept();
//		
//		//Verify Result Message is displayed
////		Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
//		
//		Assert.assertTrue(driver.findElement(resultMessage).getText().equals("You clicked an alert successfully"));
//		
//		
//		
//		
//		
//	}
	
	@Test
	public void TC_06_Alert_Cancel() throws InterruptedException {
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		By resultMessage = By.xpath("//p[@id = 'result']");
		
		// click to Alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		//Get Alert Message
		String alertMessage = alert.getText();
		
		//Verify Alert Message
		Assert.assertEquals(alertMessage, "I am a JS Confirm");
		
		//Click OK on Alert popup
		alert.dismiss();
		
		//Verify Result Message is displayed
//		Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
		
		Assert.assertTrue(driver.findElement(resultMessage).getText().equals("You clicked: Cancel"));
			
		
	}
	
	@Test
	public void TC_07_Alert_Entered() throws InterruptedException {
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		By resultMessage = By.xpath("//p[@id = 'result']");
		
		// click to Alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		//Get Alert Message
		String alertMessage = alert.getText();
		
		//Verify Alert Message
		Assert.assertEquals(alertMessage, "I am a JS Confirm");
		
		//Click OK on Alert popup
		alert.dismiss();
		
		//Verify Result Message is displayed
//		Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
		
		Assert.assertTrue(driver.findElement(resultMessage).getText().equals("You clicked: Cancel"));
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
		
	public void clickElementByJavascript(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}
		
	

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
