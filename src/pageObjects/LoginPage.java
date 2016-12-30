package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy (id = "email")
	public WebElement emailId;
	
	@CacheLookup
	@FindBy (id = "password")
	public WebElement password;
	
	@CacheLookup
	@FindBy (id = "submit-button")
	public WebElement submit;
	
}
