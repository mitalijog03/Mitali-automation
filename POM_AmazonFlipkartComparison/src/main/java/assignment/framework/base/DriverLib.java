package assignment.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverLib {
	 static WebDriver driver;

     public static WebDriver StartBrowser(String browsername)
     {
                

               // If the browser is Chrome
              if(browsername.equalsIgnoreCase("Chrome"))
              {
                          // Set the path for chromedriver.exe
     		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\drivers\\chromedriver.exe");
                   driver = new ChromeDriver();
              }
            
                  return driver;
           }
}
