package course7_topic10_frame_iframe;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.testng.annotations.AfterClass;

public class TEST_Handle_Window_Newtab {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Windows() throws InterruptedException {
		driver.get("http://live.guru99.com/");
		String parentID = driver.getWindowHandle();
		
		
		//click on Mobile
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		
		//add item for  compare
		
		driver.findElement(By.xpath("//a[text()='Sony Xperia']//parent::h2[@class='product-name']//following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		driver.findElement(By.xpath("//a[text()='IPhone']//parent::h2[@class='product-name']//following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		
		//Click on compare
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		
		//Switch on new Tab
		switchToWindowByTitle("Products Comparison List - Magento Commerce");
		
		//verify title
		Assert.assertEquals("Products Comparison List - Magento Commerce", driver.getTitle());
		
		System.out.println("VERIFY SUCCESS");
		
		Thread.sleep(5000);
		
		//Close all tab without parent tab
//		closeAllTabWithoutParentTab("Home page");
		
		closeAllTabWithoutParentTab1(parentID);
		
	
	}

	public void switchToWindowByID(String parentID) {
		// get all id tab
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String runwindow: allWindows) {
			System.out.println(runwindow);
		}

		for (String runWindow : allWindows) {

			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
		
	}

	public void switchToWindowByTitle(String expectedTitle) {
		// get all id tab
		Set<String> allWindows = driver.getWindowHandles();

		for (String runwindow : allWindows) {
			System.out.println(runwindow);
		}

		for (String runWindow : allWindows) {

			driver.switchTo().window(runWindow);
			String currentTitle = driver.getTitle();
			if(currentTitle.equals(expectedTitle)) {
				break;
			}
		}

	}
	
	public void closeAllTabWithoutParentTab(String parentTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow : allWindows) {
			
			driver.switchTo().window(runWindow);
			String currentTitle = driver.getTitle();
			if(!currentTitle.equals(parentTitle)) {
				driver.close();
			}
			
			
		}
		switchToWindowByTitle(parentTitle);
				
	}
	
	public void closeAllTabWithoutParentTab1(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow : allWindows) {
			
			
//			String currentTitle = driver.getTitle();
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
			
			
		}
		driver.switchTo().window(parentID);
		
				
	}
	
	public void testBreak(int a) {
		int[] b = new int[] {1, 2, 3, 4, 5};
		for(int i: b) {
			
			System.out.println(i);
			if(i == a) {
				break;
			}
		}
		
	}

	@AfterClass
	public void afterClass() {
	}

}
