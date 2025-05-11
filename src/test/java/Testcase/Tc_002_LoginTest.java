package Testcase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.Baseclass;
import PageObjects.Home_Page;
import PageObjects.Loginpage;
import PageObjects.MyaccountPage;

public class Tc_002_LoginTest  extends Baseclass
{
	
	
	@Test(groups={"sanity","Master"})
	public void verify_login() throws IOException
	{
		
		
		//Home page
		Home_Page hp=new Home_Page(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		//Login
		Loginpage lp=new Loginpage(driver);
		lp.setusername("umesha123@gmail.com");
		lp.setpassword("xyz123456");
		lp.clickonlogin();
		
		//Myaccount
		MyaccountPage macc=new MyaccountPage(driver);
		  boolean  targetpage=macc.isMyaccountPageExists();
		Assert.assertTrue(targetpage);
		
		
		
	}
	

}
