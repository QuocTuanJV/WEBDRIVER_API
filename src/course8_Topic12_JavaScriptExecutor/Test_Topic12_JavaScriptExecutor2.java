package course8_Topic12_JavaScriptExecutor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_Topic12_JavaScriptExecutor2 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//		driver = new ChromeDriver();
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		driver.get("http://live.guru99.com");
		
		//click on My Account
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		
		clickToElementByJS(myAccountLink);
		System.out.println("click success 1");
		
		WebElement createACBtn = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		
		//click on Create an Account
		clickToElementByJS(createACBtn);
		System.out.println("click success 2");
		
		
		WebElement firstNameTxt = driver.findElement(By.xpath("//input[@id='firstname']"));
		WebElement lastNameTxt = driver.findElement(By.xpath("//input[@id='lastname']"));
		WebElement emailTxt = driver.findElement(By.xpath("//input[@id='email_address']"));
		WebElement passwordTxt = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement confirmpwTxt = driver.findElement(By.xpath("//input[@id='confirmation']"));
		WebElement registerBtn = driver.findElement(By.xpath("//button[@title='Register']"));
		
			
		//Fill data
		sendkeyToElementByJS(firstNameTxt, "LUONG");
		sendkeyToElementByJS(lastNameTxt, "TUAN");
		
		String mail = "LUONGTUAN"+ getRandomDoubleBetweenRange(1, 1000) + "@gmail.com";
		sendkeyToElementByJS(emailTxt, mail);
		System.out.println(mail);
		
		sendkeyToElementByJS(passwordTxt, "010892");
		sendkeyToElementByJS(confirmpwTxt, "010892");
		
		
		
		//click button register
		clickToElementByJS(registerBtn);
		
		//VERIFY TEXT SCCESS REGISTER
		String messageSuccess = (String) executeForBrowser("return document.documentElement.innerText");
		
		Assert.assertTrue(messageSuccess.contains("Thank you for registering with Main Website Store."));
		System.out.println("VERIFY SUCCESS");
		
		//click Account
//		clickToElementByJS(driver.findElement(By.xpath("//a[@class='skip-link skip-account skip-active']//span[text()='Account']")));
		clickToElementByJS(driver.findElement(By.xpath("//span[text()='Account']")));
		clickToElementByJS(driver.findElement(By.xpath("//a[text()='Log Out']")));
		
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
			return js.executeScript("arguments[0].removeAttribute('" + attribute +"');",element);
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
	
	public static double getRandomDoubleBetweenRange(double min, double max){
	    double x = (Math.random()+((max-min)+1))+min;
	    return x;
	}
	
	

}
