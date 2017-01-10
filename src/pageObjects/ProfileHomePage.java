package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import config.Driver;

public class ProfileHomePage {

	private WebDriver driver;

	public ProfileHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//*[@id=\"compDetail\"]/div[4]/div[1]/button")
	WebElement updateProfileButton;

	@CacheLookup
	@FindBy (xpath = "//a[text()='Edit']")
	List<WebElement> editElements;

	@FindBy (id = "contactAddress")
	WebElement address;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement saveButton;

	@FindBy (id = "confirmMessage")
	public WebElement message;
	
	public void editAndSaveProfile(){
		Random rand = new Random();
		int randomNum = 1 + rand.nextInt((49) + 1);
		updateProfileButton.click();
		editElements.get(0).click();	
		address.clear();
		address.sendKeys("Plot No. KD-"+ randomNum + ", City Centre, Sector 4, Bokaro Steel City, Jharkhand");
		Driver.WaitAndClickElement(saveButton);
	}
}
