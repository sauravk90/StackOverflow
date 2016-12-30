package testScripts;
import org.testng.annotations.Test;
import config.Driver;
import pageObjects.LoginPage;
import testBase.TestBase;
import utilities.Constants;

public class Login extends TestBase {
	
  @Test
  public void ValidateLogin() {
	  LoginPage loginObj = new LoginPage(driver);
	  
	  driver.get(Constants.baseUrl);
	  loginObj.emailId.sendKeys("saurav.kumar90@hotmail.com");
	  loginObj.password.sendKeys("Jaycutler1!");
	  Driver.WaitAndClickElement(loginObj.submit);
	  //sample
  }
  
}
