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
	@FindBy (id = "login_Layer")
	WebElement loginText;
	
	@CacheLookup
	@FindBy (id = "eLogin")
	WebElement emailId;

	@CacheLookup
	@FindBy (id = "pLogin")
	WebElement password;

	@CacheLookup
	@FindBy (xpath = "//*[@id=\"lgnFrm\"]/div[8]/button")
	WebElement loginButton;

	public void setEmail(String email){
		emailId.clear();
		emailId.sendKeys(email);
	}

	public void setPassword(String passwordText){
		password.clear();
		password.sendKeys(passwordText);
	}

	public void LoginAndSubmitForm(String id, String password){
		Driver.WaitAndClickElement(loginText);
		setEmail(id);
		setPassword(password);
		Driver.WaitAndClickElement(loginButton);
		
	}
	
}
