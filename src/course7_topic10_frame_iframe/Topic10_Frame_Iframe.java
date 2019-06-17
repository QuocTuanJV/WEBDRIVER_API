package course7_topic10_frame_iframe;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		 driver.get("https://www.hdfcbank.com");
		  //get list iframe
		  List<WebElement> listNotification = driver.findElements(By.xpath("//iframe[@id='notification']"));
		  
		  //case 1: have pop up
		  if(listNotification.size()>0) {
			  driver.switchTo().frame(listNotification.get(0));// access iframe by index
			  clickElementByJavascript(driver.findElement(By.cssSelector("#div-close")), driver);// click close pop up by function javacript
			  System.out.println("Close pop up success");
			  
			  driver.switchTo().defaultContent();// Refresh DOM to catch other iframe
		  }
		  
		  
		  //case 2: Don't have pop up
		  
		  System.out.println("Switch to looking for iframe");
		  WebElement lookingForIframe = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));
		  driver.switchTo().frame(lookingForIframe);
		  String messageText = driver.findElement(By.xpath("//span[@id='messageText']")).getText();
		  Assert.assertEquals(messageText, "What are you looking for?");
		  
		  
		  //Refresh DOM
		  driver.switchTo().defaultContent();
		  
		  //Get Image in Iframe
		  // get in ifame contain image
		  WebElement slidingIframe = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe"));
		  driver.switchTo().frame(slidingIframe);
		  
		  //get xpath image in iframe
		  List<WebElement> bannerImg = driver.findElements(By.xpath("//div[@id='bannercontainer']//img[@class='bannerimage']"));
		  int bannerImgNumber = bannerImg.size();
		  
		  Assert.assertEquals(6, bannerImgNumber);
		  
		  //Refresh DOM
		  driver.switchTo().defaultContent();
		  
		  List<WebElement> imgDisplay = driver.findElements(By.xpath("//div[@class='flipBanner']//img[@class='front icon']"));
		  
		  for(WebElement img: imgDisplay) {
		 
			  Assert.assertTrue(img.isDisplayed());
			  System.out.println(img.isDisplayed());
		  }
		  
	}
	
	public void clickElementByJavascript(WebElement element, WebDriver driver) {
		  JavascriptExecutor je =(JavascriptExecutor) driver;
		  je.executeScript("arguments[0].click()", element);
	  }

	@AfterClass
	public void afterClass() {
	}

}
