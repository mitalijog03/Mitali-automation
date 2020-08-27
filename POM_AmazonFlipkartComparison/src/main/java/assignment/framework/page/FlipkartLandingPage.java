package assignment.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartLandingPage {
	
	WebDriver driver;
	
	/* *********************** Locator for Flipkart Landing Page*********************** */
	public By closeIconLoginPop =  By.xpath("//button[@class='_2AkmmA _29YdH8']");
	public By search = By.xpath("//input[@class='LM6RPg']");
	public By searchIcon = By.xpath("//button[@class='vh79eN']");
	
	
	/* *********************** Function for Flipkart Landing Page*********************** */
	
	public FlipkartLandingPage(WebDriver dr)
    {
                   this.driver=dr;
     }
	
	
	public void closeLoginPop() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(closeIconLoginPop)).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void searchText(String str) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);	
			wait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys(str);
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon)).click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
