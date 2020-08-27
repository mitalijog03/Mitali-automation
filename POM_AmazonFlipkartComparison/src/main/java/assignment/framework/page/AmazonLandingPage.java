package assignment.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AmazonLandingPage  {
	
	WebDriver driver;
	
	/* *********************** Locator for Amazon Landing Page*********************** */
	public By search =  By.xpath("//input[@id='twotabsearchtextbox']");
	public By searchIcon = By.xpath("//div[@class='nav-search-submit nav-sprite']");
	public By selectMobile(String str) {
		return By.xpath("//span[text()='"+str+"']");
	}
	
	
	
	/* *********************** Function for Amazon Landing Page*********************** */
	
	public AmazonLandingPage(WebDriver dr)
    {
                   this.driver=dr;
     }
	
	
	public void searchText(String str) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 50);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys(str);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(searchIcon)).click().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
