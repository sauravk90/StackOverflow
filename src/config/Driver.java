package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import testBase.TestAutomationException;

public class Driver {

	 public static WebDriver driver;
	
	 public static void Initialize(String driverType)
     {
         switch (DriverType.valueOf(driverType))
         {
             case Chrome:
                 InitializeChrome();
                 break;
                 
             case Firefox:
                 InitializeFireFox();
                 break;
                 
             default:
            	 InitializeChrome();
            	 break;
         }    
}
	 
	 private static void InitializeChrome()
     {
			System.setProperty("webdriver.chrome.driver","C:\\Saurav.Kumar_NOVO_Backup\\Desktop\\Dumps\\New folder\\chromedriver\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
	        options.addArguments("test-type");
	        options.addArguments("chrome.switches", "--disable-extensions");
	        driver = new ChromeDriver( options);		
     }
	 
	 private static void InitializeFireFox()
     {
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\saurav.kumar\\Desktop\\Dumps\\New folder\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
     }
	 
	  public enum DriverType
      {
          InternetExplorer,
          Chrome,
          Firefox
      }
	  
	  public static void WaitAndClickElement(WebElement ele)
      {
          try
          {
        	  WebDriverWait wait = new WebDriverWait(driver, 15);
        	  wait.until(ExpectedConditions.visibilityOf(ele));
              ele.click();
          }
          catch (Exception exception)
          {
             throw new TestAutomationException("Element not visible");
          }
      }
	  
	  public static void WaitForPageToLoad() throws InterruptedException
      {
		  int timeout = 0;
          while (!GetDocumentReadyState().equals("complete"))
          {
              Thread.sleep(1000);
              if (timeout > 30) throw new TestAutomationException("Timeout while waiting for loading to complete.");
              timeout++;
          }
      }
	  
      public static String GetDocumentReadyState() {    	 
    	  return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString();
      }
  
	  
}
