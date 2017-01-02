package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.Driver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy (id = "email")
	WebElement emailId;

	@CacheLookup
	@FindBy (id = "password")
	WebElement password;

	@CacheLookup
	@FindBy (id = "submit-button")
	WebElement submit;

	public void setEmail(String email){
		emailId.clear();
		emailId.sendKeys(email);
	}

	public void setPassword(String passwordText){
		password.clear();
		password.sendKeys(passwordText);
	}

	public void ClickOnSubmit(){
		Driver.WaitAndClickElement(submit);
	}
	
}
