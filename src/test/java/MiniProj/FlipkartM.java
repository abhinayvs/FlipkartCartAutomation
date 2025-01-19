package MiniProj;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FlipkartM {

	public WebDriver driver;
	double priceOne;
	double priceTwo;
	
	double totalPrice;
	
	@BeforeClass
	public void test_launchApplication() throws IOException {
		BaseTestM basetest = new BaseTestM();
		driver = basetest.setup("chrome");
	}
	
	@Test(priority=1)
	public  void test_enteringSearchValue() throws IOException, InterruptedException {
		HomePageM homepage = new HomePageM(driver);
		homepage.search();
	}
	
	@Test(priority=2, dependsOnMethods = {"test_enteringSearchValue"})
	public void test_cartForFirstItem() throws InterruptedException, IOException {
		 CartHandlingM cart = new CartHandlingM(driver);
		 priceOne = cart.addFirstItem();
		 System.out.println("Price of first item: "+priceOne);
	}
	
	@Test(priority = 3, dependsOnMethods = {"test_cartForFirstItem"})
	public void test_cartForSecondItem() throws IOException, InterruptedException {
		CartHandlingM cart = new CartHandlingM(driver);
		priceTwo = cart.addsecondItem();
		System.out.println("Price of second item: "+priceTwo);
	}
	
	@Test(priority = 4, dependsOnMethods = {"test_cartForSecondItem"})
	public void test_totalPrice() {
		CartHandlingM cart = new CartHandlingM(driver);
		totalPrice = cart.totalPrice();
		System.out.println("Total price: "+totalPrice);
	}
	
	@Test(priority = 5, dependsOnMethods = {"test_totalPrice"})
	
	public void validation() {
		
		double tPrice = priceOne+priceTwo;
		if(tPrice==totalPrice) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		BaseTestM basetest = new BaseTestM();
		basetest.tearDown();
	}
}
