package assignment.framework.page;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartSearchResultPage {

	
	
	WebDriver driver;
	
	/* *********************** Locator for Flipkart Search Result Page*********************** */
	public By selectMobile(String str) {
		return By.xpath("//div[text()='"+str+"']");
	}
	
	public By priceTag = By.xpath("//div[@class='_1vC4OE _3qQ9m1']");
	
	
	
	/* *********************** Function for Flipkart Search Result Page*********************** */
	
	public FlipkartSearchResultPage(WebDriver dr)
    {
                   this.driver=dr;
     }
	
	public void selectDevice(String str) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectMobile(str))).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public int handleTabToGetPrice() {
		try {
			 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			 
			 // Switch Tab
			 driver.switchTo().window(tabs.get(1));
			 WebDriverWait wait = new WebDriverWait(driver, 50);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(priceTag));
			 String price = driver.findElement(priceTag).getText();
			 price = price.replaceAll("[^\\d]", " "); 
			 price = price.replaceAll("\\s", ""); 

			 int number = Integer.parseInt(price);
			 System.out.println("Price of Apple iPhone XR (64GB) on Flipkart is :- "+number);
			 driver.close();
			 driver.switchTo().window(tabs.get(0));
			 return number;
			} 
		catch (Exception e) {
				System.out.println(e.getMessage());
				return -1;
			}
	}
}
