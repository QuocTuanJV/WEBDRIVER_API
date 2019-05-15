package Course6_Topic_09_UserInteraction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_09_UserInteraction {
	WebDriver driver;
	
	Actions action;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	
	@Test
	public void TC_02_MoveMouseToElement() {
		//How to check tooltip
				driver.get("https://www.myntra.com/");	
				WebElement accountLogin = driver.findElement(By.xpath("//div[@class='desktop-user']"));// way 1
				
//				WebElement accountLogin = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
				
				Actions action = new Actions(driver);
				action.moveToElement(accountLogin).perform();// move mouse to Element (call is hover)
				
				WebElement signLogin = driver.findElement(By.xpath("//a[text()='Sign up']"));
				
				Assert.assertTrue(signLogin.isDisplayed());
				
				System.out.println("Sign is Display");
				
				// click on sign up link
				signLogin.click();
				
//				check sign up screen is display
//				String sigupTextScreen = driver.findElement(By.xpath("//p[@class='register-title']")).getText();
//				
//				Assert.assertEquals(sigupTextScreen,"Signup with Myntra");
				
				Assert.assertTrue(driver.findElement(By.xpath("//p[@class='register-title']")).isDisplayed());//this element is displayed
				
				System.out.println("SignUp Screen is Display");
	
		
	}
	
	@Test
	public void TC_03_ClickAndHold() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		List <WebElement> numberRange = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		action.clickAndHold(numberRange.get(0)).moveToElement(numberRange.get(3)).release().perform();
		
		List <WebElement> numberRangeSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'selected')]"));
		
		Assert.assertEquals(numberRangeSelected.size(), 4);
		System.out.println("------Number is selected is 4-------");
		
		
		
	}
	
	@Test
	public void TC_03_01_ClickAndHold() {
		
		//Click and hold many item
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		List <WebElement> numberRange = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		action.keyDown(Keys.CONTROL).build().perform();
		numberRange.get(0).click();
		numberRange.get(2).click();
		numberRange.get(4).click();
		numberRange.get(6).click();
		action.keyUp(Keys.CONTROL).build().perform();
		
		List <WebElement> numberRangeSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'selected')]"));
		
		for(WebElement i: numberRangeSelected) {
			System.out.println("Number is selected: " + i.getText());
		}
		

		Assert.assertEquals(numberRangeSelected.size(), 4);
		System.out.println("------Number is selected is 4-------");
		
	}
	
	@Test
	public void TC_04_01_DoubleClick() {
		
		//Click and hold many item
		driver.get("http://www.seleniumlearn.com/double-click");
		
		WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me!')]"));
		
		action.doubleClick(doubleClick).perform();
		
		Alert arlert = driver.switchTo().alert();
		
		String messageAlert = arlert.getText();
		
		Assert.assertEquals(messageAlert, "The Button was double-clicked." );
		
		
		
		
	}

	@AfterClass
	public void afterClass() {
	}

}
