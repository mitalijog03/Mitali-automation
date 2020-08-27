package assignment.framework.page;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchResult {
	WebDriver driver;
	
	/* *********************** Locator for Amazon Landing Page*********************** */
	public By selectMobile(String str) {
		return By.xpath("//span[text()='"+str+"']");
	}
	
	public By priceTag = By.xpath("//span[@id='priceblock_ourprice']");
	
	
	
	/* *********************** Function for Amazon Landing Page*********************** */
	
	public AmazonSearchResult(WebDriver dr)
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
			 String abc = driver.findElement(priceTag).getText();
			 
			 String[] splited = abc.split("\\s+");
			 
			 NumberFormat format = NumberFormat.getInstance(Locale.US);
			 Number num = 0;
			 num = format.parse(splited[1]);
			 int number = num.intValue();
			 System.out.println("Price of Apple iPhone XR (64GB) on Amazon is :- "+number);
			 driver.close();
			 driver.switchTo().window(tabs.get(0));
			 return number;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return -1;
			}
	}
}
