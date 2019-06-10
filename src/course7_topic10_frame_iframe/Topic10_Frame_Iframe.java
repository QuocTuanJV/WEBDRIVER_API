package course7_topic10_frame_iframe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Topic10_Frame_Iframe {
	
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_Iframe() {
		driver.get("https://www.hdfcbank.com/");
		
		WebElement notification1 = driver.findElement(By.xpath("//iframe[@id='destination_publishing_iframe_hdfcbank_0']"));
		if(notification.isDisplayed()) {
			driver.switchTo().frame(notification1);
			driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
			System.out.println("Found Car");
		}
		System.out.println("Not Found Car");
		
		WebElement notification2 = driver.findElement(By.xpath("//iframe[@id='destination_publishing_iframe_hdfcbank_0']"));
		if(notification.isDisplayed()) {
			driver.switchTo().frame(notification1);
			driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
			System.out.println("Found element");
		}
		System.out.println("Not Found");
	}

	@AfterClass
	public void afterClass() {
	}

}
