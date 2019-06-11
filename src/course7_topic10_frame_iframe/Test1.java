package course7_topic10_frame_iframe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test1 {
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
	  driver.get("https://www.hdfcbank.com/");
	  
	  List<WebElement> listNotification = driver.findElements(By.xpath("//iframe"));
	  
	  for(WebElement i : listNotification) {
		  
	  System.out.println(i.getAttribute("id"));
	  }
  }

  @AfterClass
  public void afterClass() {
  }

}
