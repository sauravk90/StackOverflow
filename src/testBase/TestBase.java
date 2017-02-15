package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import config.Driver;
import config.Driver.DriverType;

public class TestBase extends Driver {

	public String baseUrl;
	
	@BeforeSuite 
	@Parameters({"browser"})
	public void setUp(String browser) throws TestAutomationException{
		
		Driver.Initialize(browser);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
		System.out.println("Test Execution was completed.");
	}
}
