package course8_Topic12_JavaScriptExecutor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic12_JavaScriptExecutor {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		driver.get("https://www.google.com/");
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
			return js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	

}
