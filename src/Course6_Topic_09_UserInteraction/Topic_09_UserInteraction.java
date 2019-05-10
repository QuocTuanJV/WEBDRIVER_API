package Course6_Topic_09_UserInteraction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_09_UserInteraction {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	
	@Test
	public void TC_02_MoveMouseToElement() {
		//How to check tooltip
				driver.get("https://www.myntra.com/");	
//				WebElement accountLogin = driver.findElement(By.xpath("//div[@class='desktop-user']"));// way 1
				
				WebElement accountLogin = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
				
				Actions action = new Actions(driver);
				action.moveToElement(accountLogin).perform();// move mouse to Element (call is hover)
				
				WebElement signLogin = driver.findElement(By.xpath("//a[text()='Sign up']"));
				
				Assert.assertTrue(signLogin.isDisplayed());
				
				System.out.println("Sign is Display");
				
				// click on sign up link
				signLogin.click();
				
				//check sign up screen is display
//				String sigupTextScreen = driver.findElement(By.xpath("//p[@class='register-title']")).getText();
//				
//				Assert.assertEquals(sigupTextScreen,"Signup with Myntra");
				
				Assert.assertTrue(driver.findElement(By.xpath("//p[@class='register-title']")).isDisplayed());//this element is displayed
				
				System.out.println("SignUp Screen is Display");
	
		
	}
	

	@AfterClass
	public void afterClass() {
	}

}
