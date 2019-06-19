package course8_Topic12_JavaScriptExecutor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_Topic12_JavaScriptExecutor2 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		driver.get("http://live.guru99.com/");
		
		//Get domain home page
		String domainName = (String) executeForBrowser("return document.domain");
		Assert.assertEquals(domainName, "live.guru99.com");
		
		//Get Url home page
		String homePageUrl = (String) executeForBrowser("return document.URL");
		Assert.assertEquals(homePageUrl, "http://live.guru99.com/");
		
		//Click element use JE
		WebElement mobilePageLink = driver.findElement(By.xpath("//a[text()='Mobile']"));
		clickToElementByJS(mobilePageLink);	
		
		//add  item by click 
		WebElement samsumgGalaxyButton = driver.findElement(By.xpath("//a[text()='Samsung Galaxy']//parent::h2/following-sibling::div[@class='actions']/button"));
		clickToElementByJS(samsumgGalaxyButton);
		
//		String messageAdd = driver.findElement(By.xpath("//span[text()='Samsung Galaxy was added to your shopping cart.']")).getText();
//		Assert.assertEquals(messageAdd, "Samsung Galaxy was added to your shopping cart.");
		String messageAdd = (String) executeForBrowser("return document.documentElement.innerText");
		Assert.assertTrue(messageAdd.contains("Samsung Galaxy was added to your shopping cart."));
		
		//Click on Privacy Policy
		WebElement privacyLink = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		clickToElementByJS(privacyLink);
		
		String privacyTitle = (String) executeForBrowser("return document.title");
		Assert.assertEquals(privacyTitle, "Privacy Policy");
		
		//Scroll bottom page
		scrollToBottomPage();
		
		//Verify data by one link
		WebElement dataTable = driver.findElement(By.xpath("//th[text()='WISHLIST_CNT']/following-sibling::td"));
		Assert.assertEquals(dataTable.getText(), "The number of items in your Wishlist.");
		
		//navigate to other URL
		navigateToUrlByJS("http://demo.guru99.com/v4/");
		Assert.assertEquals((String) executeForBrowser("return document.domain"),"demo.guru99.com" );

		
	}

	@AfterClass
	public void afterClass() {
	}
	//High element
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}
	
	public Object executeForBrowser(String javaScript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaScript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public Object clickToElementByJS(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click()",element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public Object sendkeyToElementByJS(WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].setAttribute('value','" + value +"')",element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public Object removeAttributeInDOM(WebElement element, String attribute) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('value','" + attribute +"')",element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public Object scrollToBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public Object navigateToUrlByJS(String url) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.location = ' "+ url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	

}
