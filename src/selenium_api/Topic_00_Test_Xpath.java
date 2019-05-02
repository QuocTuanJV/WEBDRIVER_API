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

public class Topic_00_Test_Xpath {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void f() {
		// get page
//		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
//		
//		//
////		driver.findElement(By.xpath("//span[@aria-owns='color_listbox']")).click();//xPath parent--//span[@class='k-input'][contains(text(),'Black')]
////		driver.findElement(By.xpath("//span[@aria-owns='color_listbox']/span[@class='k-dropdown-wrap k-state-default']")).click();
//		////span[@aria-owns='color_listbox']/span[@class='k-dropdown-wrap k-state-default']
//		handleCustomDropDown("//span[@aria-owns='color_listbox']", "//ul[@id='color_listbox']/li", "Orange");
//		
//		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Orange')]")).isDisplayed());
//		System.out.println("ITEM ORANGE IS SELECTED");
		
		driver.get("https://material.angular.io/components/select/examples");
		
		handleCustomDropDown("//mat-select[@role ='listbox' and @id='mat-select-5']", "//mat-option/span", "Washington");
		
		Assert.assertTrue(driver.findElement(By.xpath("//mat-select[@role ='listbox' and @id='mat-select-5']//span[contains(text(),'Washington')]")).isDisplayed());
		
		System.out.println("WASHINGTON IS CHOSED");

		
	}
	
	@Test
	public void TC_05_Alert() {
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		By resultMessage = By.xpath("//p[@id = 'result']");
		
		// click to Alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		
		Alert alert = driver.switchTo().alert();
		
		//Get Alert Message
		String alertMessage = alert.getText();
		
		//Verify Alert Message
		Assert.assertEquals(alertMessage, "I am a JS Alert");
		
		//Click OK on Alert popup
		alert.accept();
		
		//Verify Result Message is displayed
//		Assert.assertTrue(driver.findElement(resultMessage).isDisplayed());
		
		Assert.assertTrue(driver.findElement(resultMessage).getText().equals("You clicked an alert successfully"));
		
		
		
		
	}
	
	public void handleCustomDropDown(String parentXpath, String childXpath, String expected) {
		WebElement wb = driver.findElement(By.xpath(parentXpath));
		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", wb);
		wb.click();
		
		List<WebElement> childList = driver.findElements(By.xpath(childXpath));
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		
		for(WebElement i: childList) {
			
			System.out.println("ITEM: " + i.getText());
			if(i.getText().equals(expected)) {
				javaExecutor.executeScript("arguments[0].scrollIntoView(true);", i);
				i.click();
				break;
			}
		}
		
		
		
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
