package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import config.Driver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy (name = "qp")
	WebElement jobName;

	@CacheLookup
	@FindBy (id = "ql")
	WebElement location;

	@CacheLookup
	@FindBy (id = "qsbFormBtn")
	WebElement submit;

	public void searchJob(String job, String userLocation){
		jobName.sendKeys(job);
		location.sendKeys(userLocation);
		Driver.WaitAndClickElement(submit);
	}
	
}
