package Testcase;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Baseclass.Baseclass;
import PageObjects.AccountRegsitrationpage;
import PageObjects.Home_Page;

public class TC_001Accountregistration extends Baseclass
{
	
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_Registration()
	{
		Home_Page hp=new Home_Page(driver);
		hp.clickmyaccount();
		hp.clickregister();
		
		AccountRegsitrationpage regpage=new AccountRegsitrationpage(driver);
		regpage.setFirstName(randomeString());
		regpage.setLastName(randomeString());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
	String	   password=randomAlphanumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickonContinue();
		
	String	     confmsg=regpage.getconfirmationMsg();
	Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
	}
	


}
