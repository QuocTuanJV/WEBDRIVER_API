package Course6_Topic_09_UserInteraction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_Element_Topic_09_UserInteraction {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		set path to geckodriver with firefox >= 48
//		System.setProperty("webdriver.chrome.driver", ".\\lib\\geckodriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

//	@Test
//	public void TC_01_MoveMouseToElement() {
//		//How to check tooltip
//		driver.get("https://daominhdam.github.io/basic-form/index.html");	
//		WebElement hoverMe = driver.findElement(By.xpath("//a[contains(text(),'Hover over me')]"));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(hoverMe).perform();// move mouse to Element
		
		
//	}
	
//	@Test
//	public void TC_02_MoveMouseToElement() {
//		//How to check tooltip
//		driver.get("https://www.myntra.com/");	
////		WebElement accountLogin = driver.findElement(By.xpath("//div[@class='desktop-user']"));// way 1
//		
//		WebElement accountLogin = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(accountLogin).perform();// move mouse to Element (call is hover)
//		
//		WebElement signLogin = driver.findElement(By.xpath("//a[text()='Sign up']"));
//		
//		Assert.assertTrue(signLogin.isDisplayed());
//		
//		System.out.println("Sign is Display");
		
		
//	}
	
//	@Test
//	public void TC_04_01_RightClick() {
//		
//		//Click and hold many item
//		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
//		
//		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
//		Actions action = new Actions(driver);
//		//right click on button
//		action.contextClick(rightClick).perform();
//	
//		
//		WebElement beforeQuit = driver.findElement(By.xpath("//li/span[text()='Quit']"));
//		
//		//Move mouse on quit element
//		action.moveToElement(beforeQuit).perform();
//		
//		//verify element is displayed
//		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'hover') and contains(@class,'visible')]/span[text()='Quit']")).isDisplayed());
//		System.out.println("VERIFY ITEM SUCCESS");
//		
//		//Click left mouse on hover element
//		
//		action.click().perform();
//		
//		Alert arlert = driver.switchTo().alert();
//		
//		String messageAlert = arlert.getText();
//		
//		Assert.assertEquals(messageAlert, "clicked: quit" );
//		
//		arlert.accept();
//		
//	}
	
	@Test
	public void TC_05_DragAndDrop() {
		
		//Click and hold many item
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droptarget']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement).perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='You did great!']")).isDisplayed());
		
		System.out.println("Drag sucess");
		

		
	}
	

	@AfterClass
	public void afterClass() {
	}

}
