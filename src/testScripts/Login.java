package testScripts;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import config.Driver;
import pageObjects.LoginPage;
import testBase.TestBase;
import utilities.Constants;
import utilities.ReadWriteExcel;

public class Login extends TestBase {
	
  @Test
  public void ValidateLogin() throws IOException, Exception {
	  LoginPage loginObj = new LoginPage(driver);
	  
	  String homeWindow = driver.getWindowHandle();
	  System.out.println(homeWindow);
	  driver.get(Constants.baseUrl);
	  Set<String> windowSet = driver.getWindowHandles();
	  System.out.println(windowSet.size());
	  
	  for (String id : windowSet) {
		if(!id.equals(homeWindow)){
			driver.switchTo().window(id);
			driver.close();
			System.out.println("closed id : " + id);
		}
			}

	  driver.switchTo().window(homeWindow);
      loginObj.LoginAndSubmitForm("saurav.kumar90@hotmail.com","stonewarrior080");

      Thread.sleep(12000);
  }
  
}