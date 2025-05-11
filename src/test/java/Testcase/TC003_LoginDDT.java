package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.Baseclass;
import PageObjects.Home_Page;
import PageObjects.Loginpage;
import PageObjects.MyaccountPage;
import Utility.DataProviders;

public class TC003_LoginDDT extends Baseclass
{
	@Test(dataProvider ="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
	//Home page
			Home_Page hp=new Home_Page(driver);
			hp.clickmyaccount();
			hp.clicklogin();
			
			//Login
			Loginpage lp=new Loginpage(driver);
			lp.setusername(email);
			lp.setpassword(pwd);
			lp.clickonlogin();
			
			//Myaccount
			MyaccountPage macc=new MyaccountPage(driver);
			  boolean  targetpage=macc.isMyaccountPageExists();
			Assert.assertTrue(targetpage);
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetpage==true)
				{
					Assert.assertTrue(true);
					macc.clicklogout();
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetpage==true)
				{
					macc.clicklogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
	}
}
