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

public class Topic12_JavaScriptExecutor {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver = new FirefoxDriver();
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

	@Test
	public void TC_02() throws InterruptedException {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		
		WebElement lastNameTxt = driver.findElement(By.xpath("//input[@name= 'lname']"));
		WebElement firstNameTxt = driver.findElement(By.xpath("//input[@name= 'fname']"));
		WebElement submitBt = driver.findElement(By.xpath("//input[@value='Submit']"));
		
		//remove attribute
		removeAttributeInDOM(lastNameTxt, "disabled");
		
//		driver.switchTo().defaultContent();
//		clickToElementByJS(driver.findElement(By.xpath("//button[contains(text(),'Run')]")));
		
		//send key to text box
		
		sendkeyToElementByJS(firstNameTxt, "Automation");
		sendkeyToElementByJS(lastNameTxt,"Testing");
		
		Thread.sleep(3000);
		
		//click on submit button
		
		clickToElementByJS(submitBt);
		
		//get Text
		WebElement  textResult = driver.findElement(By.xpath("//h2[text()='Your input was received as:']/following-sibling::div[contains(text(),'fname')]"));
		
		System.out.println(textResult.getText());
		Assert.assertTrue(textResult.getText().contains("Automation") && textResult.getText().contains("Testing"));
		
		System.out.println("VERIFY SUCCESS");
		
	
	}
	
	@Test
	public void TC_03() {
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
			return js.executeScript("arguments[0].setAttribute('value','" + value +"');",element);
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
			return js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public Object isDisplayImageByJS(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",element);
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
