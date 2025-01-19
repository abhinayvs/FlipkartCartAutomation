package MiniProj;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestM {

	static WebDriver driver;

	@BeforeClass
	public  WebDriver setup(String browser) throws IOException {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		driver.get("https://flipkart.com/");
		//Takes screenshot of the window
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Automation\\workspace\\Selenium\\OnlineShoppingAutomation\\Screenshots\\homePage.png");
		FileUtils.copyFile(srcFile, destFile);

		return driver;
	
	}
	
	@AfterClass
	public  void tearDown() {
		driver.quit();
	}
	
	
}

