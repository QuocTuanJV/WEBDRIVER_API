package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_05_Handle_Dropdown_List {
	WebDriver driver;
	WebDriverWait waitExplicit;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		waitExplicit = new WebDriverWait(driver, 60);

//		driver = new FirefoxDriver();

		// driver.get("");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Handle_HTML_DropDownlist() {
		//Go to  Link
		//Step 01:
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		
		//Step 02: Check drop down Job Role 01 not support attribute multi - select
		
		Select  select = new Select(driver.findElement(By.xpath("//select[@name ='user_job1']")));
		Assert.assertFalse(select.isMultiple());
		System.out.println("DROP DOWN JOB ROLE 01 NOT SUPPORT MULTI - SELECT");
		
		//STEP 03: Select value Automation Tester in drop down on method select Visible
		select.selectByVisibleText("Automation Tester");
		
		//STEP 04: Check successfully select
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Automation Tester");
		System.out.println("SELECT AUTOMATION TESTER SUCCESS");
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//STEP 05: SELECT VALUE MANUAL TESTER IN DROP DOWN ON METHOD SELECT VALUE
		select.selectByValue("manual");
		
		//STEP 06: CHEKC SUCCESSFULLY SELECT
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Tester");
		System.out.println("SELECT MANUAL TESTER SUCCESS");
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//STEP 07: SELECT MOBILE TESTER IN DROP DOWN ON METHOD SELECT INDEX
		select.selectByIndex(3);
		
		//STEP 08: CHECK SUCCESSFULLY SELECT
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Tester");
		System.out.println("SELECT MOBILE TESTER SUCCESS");
		
		//STEP 09: CHECK DROP DOWN HAVE FIVE VALUE
		Assert.assertEquals(select.getOptions().size(), 5);
		System.out.println("DROP DOWN HAVE FIVE VALUE");
		
	}
	
	@Test
	public void TC_02_Handle_Custom_Dropdown_List() throws InterruptedException {
		//STEP 01: 
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		
		//STEP 02:
		selectItemFromCustomDropDownList("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "19");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='19']")).isDisplayed());
		System.out.println("ITEM: 19 IS SELECTED");
		
		Thread.sleep(200);
		
		selectItemFromCustomDropDownList("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "15");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='15']")).isDisplayed());
		System.out.println("ITEM: 15 IS SELECTED");
		
		Thread.sleep(200);
		
		selectItemFromCustomDropDownList("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "14");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='14']")).isDisplayed());
		System.out.println("ITEM: 14 IS SELECTED");
		
		Thread.sleep(200);
		
		
		
		
	}
	
	public void selectItemFromCustomDropDownList(String parentXpath, String childXpath, String expected) {
		WebElement element = driver.findElement(By.xpath(parentXpath));
		element.click();
		
		System.out.println("CLICK SUCCESSFULLY!!!");
		
		List <WebElement> childList = driver.findElements(By.xpath(childXpath));
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		
		
		for(WebElement child: childList) {
			String itemSelect = child.getText();
			
//			System.out.println("ITEM IS: " + itemSelect);
			if(itemSelect.equals(expected))
			{
				child.click();
				break;
			}
				
		}
		
	}

	@AfterClass
	public void afterClass() {
	}

}
