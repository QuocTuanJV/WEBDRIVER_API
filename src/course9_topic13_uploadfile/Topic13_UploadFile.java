package course9_topic13_uploadfile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic13_UploadFile {
	WebDriver driver;
	
	String rootFolder = System.getProperty("user.dir");
	
	String fileName01 = "1.png";
	String fileName02 = "2.png";
	String fileName03 = "3.png";
	
	String filePath01 = rootFolder + "\\uploadFile" + fileName01;
	String filePath02 = rootFolder + "\\uploadFile" + fileName02;
	String filePath03 = rootFolder + "\\uploadFile" + fileName03;
	
	

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
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		
		
		
		
	}

	@AfterClass
	public void afterClass() {
	}

}
