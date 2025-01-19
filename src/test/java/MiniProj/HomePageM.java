package MiniProj;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HomePageM {

	private  WebDriver driver;

    public HomePageM(WebDriver driver) {
        this.driver = driver;
    }
	
//    public boolean checkHomePageIsLoaded() {
//    	boolean status = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[1]/a/picture/img")).isDisplayed();
//    	return status;
//    }
    
    
    public  void search() throws IOException, InterruptedException {
    	
    	String filePath  = "C:\\Users\\2372586\\Downloads\\FlipkartAutomation\\FlipkartAutomation\\src\\test\\resources\\data.xlsx";
    	//C:\\Automation\\workspace\\Selenium\\OnlineShoppingAutomation\\testdata\\data.xlsx
    	
    	
    	String sheet = "Sheet1";
    	
    	String searchItem = UtilsM.getCellData(filePath, sheet, 1, 0);
    	
    	driver.findElement(By.name("q")).sendKeys(searchItem);
    	Thread.sleep(2000);
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2372586\\Downloads\\FlipkartAutomation\\FlipkartAutomation\\Screenshot\\searchText.png");
		FileUtils.copyFile(srcFile, destFile);
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
    }
    
}

