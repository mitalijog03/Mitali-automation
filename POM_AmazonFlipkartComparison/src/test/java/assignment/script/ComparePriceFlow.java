package assignment.script;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import assignment.framework.base.DriverLib;
import assignment.framework.page.AmazonLandingPage;
import assignment.framework.page.AmazonSearchResult;
import assignment.framework.page.FlipkartLandingPage;
import assignment.framework.page.FlipkartSearchResultPage;


public class ComparePriceFlow  {

	WebDriver driver;
	AmazonLandingPage amazonLandingPage;
	AmazonSearchResult amazonSearchResult;
	FlipkartLandingPage flipkartLandingPage;
	FlipkartSearchResultPage flipkartSearchResultPage;
	int amazonPrice;
    int flipkartPrice;
   
	@BeforeTest
	public void browserlaunch() {
		driver = DriverLib.StartBrowser("Chrome");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		amazonLandingPage = new AmazonLandingPage(driver);
		amazonSearchResult = new AmazonSearchResult(driver);
		flipkartLandingPage = new FlipkartLandingPage(driver);
		flipkartSearchResultPage = new FlipkartSearchResultPage(driver);
	}
	
	
	

	@Test
	public void comparePrice() {

		try {
			
			/* Flow for Amazon */
			driver.navigate().to("https://www.amazon.in/");
			driver.manage().window().maximize();
			amazonLandingPage.searchText("apple iphone xr 64gb - blue");
			amazonSearchResult.selectDevice("Apple iPhone XR (64GB) - Blue");
			amazonPrice = amazonSearchResult.handleTabToGetPrice();

			/* Flow for Flipkart */
			driver.navigate().to("https://www.flipkart.com/");
			flipkartLandingPage.closeLoginPop();
			flipkartLandingPage.searchText("apple iphone xr 64gb - blue");
			flipkartSearchResultPage.selectDevice("Apple iPhone XR (Blue, 64 GB)");
			flipkartPrice = flipkartSearchResultPage.handleTabToGetPrice();

			/*
			 * Comparing the price here in script itself rather than creating a method for
			 * it in specific class
			 */

			if (amazonPrice != flipkartPrice) {
				if (amazonPrice > flipkartPrice) {
					System.out.println("Price of Apple iphone XR (64GB) is lesser on Flipkart");
				}
				else {
					System.out.println("Price of Apple iphone XR (64GB) is lesser on Amazon");
				}
			}
			else {
				System.out.println("Price of Apple iphone XR (64GB) is same on Amozan and Flipkart");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	

	
}
