package testScripts;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProfileHomePage;
import testBase.TestBase;
import utilities.Constants;
import utilities.ReadWriteExcel;
import utilities.XMLParser;

public class LoginAndEdit extends TestBase {
	
  @Test
  public void Login() throws Exception{
	  
	  LoginPage loginObj = new LoginPage(driver);
  
	  String homeWindow = driver.getWindowHandle();
	  System.out.println(homeWindow);
	  driver.get(Constants.baseUrl);
	  Set<String> windowSet = driver.getWindowHandles();
	  
	  for (String id : windowSet) {
		if(!id.equals(homeWindow)){
			driver.switchTo().window(id);
			driver.close();
		}
			}
	  driver.switchTo().window(homeWindow);
      loginObj.loginAndSubmitForm(XMLParser.ReadAndReturnXML().get("username"),XMLParser.ReadAndReturnXML().get("password"));
  }
  
  @Test
  public void editProfile() {
	  ProfileHomePage profileObj = new ProfileHomePage(driver);
	  profileObj.editAndSaveProfile();
	  Assert.assertEquals(profileObj.message.getText(), "Your profile has been updated successfully");
  }
}