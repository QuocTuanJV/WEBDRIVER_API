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
import org.testng.annotations.AfterClass;

public class Topic11_Handle_Window_Newtab {
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
		driver.get("https://daominhdam.github.io/basic-form/index.html");

//      Set<String> allWindows = driver.getWindowHandles();
//		
//		for(String runwindow: allWindows) {
//			System.out.println(runwindow);
//		}

		String parentWindowID = driver.getWindowHandle();
		System.out.println("Parent ID = " + parentWindowID);

		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();

		// after click link current window is new tab
		switchToWindowByID(parentWindowID);

		// verify navigate to Google page success
		Assert.assertEquals("Google", driver.getTitle());//

		// switch to homepage
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		Assert.assertEquals("SELENIUM WEBDRIVER FORM DEMO", driver.getTitle());
		Thread.sleep(2000);

		switchToWindowByTitle("Google");
		Assert.assertEquals("Google", driver.getTitle());
		Thread.sleep(2000);

	}

	public void switchToWindowByID(String parentID) {
		// get all id tab
		Set<String> allWindows = driver.getWindowHandles();

		for (String runwindow : allWindows) {
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
			if (currentTitle.equals(expectedTitle)) {
				break;
			}
		}

	}

	public void testBreak(int a) {
		int[] b = new int[] { 1, 2, 3, 4, 5 };
		for (int i : b) {

			System.out.println(i);
			if (i == a) {
				break;
			}
		}

	}

	@AfterClass
	public void afterClass() {
	}

}
