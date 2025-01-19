package MiniProj;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

public class CartHandlingM {
	

	private static  WebDriver driver;
	static Timeouts wait;

    public CartHandlingM(WebDriver driver) {
        CartHandlingM.driver = driver;
        
    }
	public  double addFirstItem() throws InterruptedException, IOException {
		
		wait=driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement item = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div[1]/div/a[2]"));
		item.click();
		Set <String> handles = driver.getWindowHandles();
		ArrayList <String> handleList = new ArrayList<>(handles);
		driver.switchTo().window(handleList.get(1));
		Thread.sleep(1000);
		//driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
		Thread.sleep(2000);
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2372586\\Downloads\\FlipkartAutomation\\FlipkartAutomation\\Screenshot\\firstProduct.png");
		FileUtils.copyFile(srcFile, destFile);
		String priceText = driver.findElement(By.xpath("//body/div[@id='container']/div/div[@class='z1ALT8']/div[@class='JxFEK3 _48O0EI']/div[@class='DOjaWF YJG4Cf col-12-12']/div[@class='DOjaWF gdgoEp']/div[@class='DOjaWF gdgoEp col-12-12']/div[2]/div[1]/div[1]/div[1]/span[2]")).getText();
		String price = priceText.replaceAll("[^\\d]", ""); 
		double priceOne = Double.parseDouble(price);
    	driver.switchTo().window(handleList.get(0));
		return priceOne;
    	
    	
	}
	
	public  double addsecondItem() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div[2]/div/a[2]")).click();
		Set <String> handlesA = driver.getWindowHandles();
		ArrayList <String> handleListA = new ArrayList<>(handlesA);
		driver.switchTo().window(handleListA.get(2));
		String url = driver.getCurrentUrl();
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
		Thread.sleep(2000);
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2372586\\Downloads\\FlipkartAutomation\\FlipkartAutomation\\Screenshot\\secondProduct.png");
		FileUtils.copyFile(srcFile, destFile);
		String priceText = driver.findElement(By.xpath("//body/div[@id='container']/div/div[@class='z1ALT8']/div[@class='JxFEK3 _48O0EI']/div[@class='DOjaWF YJG4Cf col-12-12']/div[@class='DOjaWF gdgoEp']/div[@class='DOjaWF gdgoEp col-12-12']/div[2]/div[1]/div[1]/div[1]/span[2]")).getText();
		String price = priceText.replaceAll("[^\\d]", ""); 
		double priceTwo = Double.parseDouble(price);

    	return priceTwo;
	}
	
	public  double totalPrice() {
		String priceT = driver.findElement(By.xpath("//div[@class='_1Y9Lgu']//span[contains(text(), '₹')]")).getText();
		String price = priceT.replaceAll("[^\\d]", ""); 
		double priceOfTotal = Double.parseDouble(price);
    	return priceOfTotal;
	}
	
	
	
}

