package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base_page.Basepage;
import Baseclass.Baseclass;

public class Loginpage  extends Basepage
{
	
	
	   public Loginpage(WebDriver driver)
	   {
		   super(driver);
	   }

	   @FindBy(xpath="//input[@id='input-email']")  WebElement  txtemail;
	   
	   @FindBy(xpath="//input[@id='input-password']")WebElement  txtpassword;

	    @FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	    
	    
	    
	    public void setusername(String email)
	    {
	    	txtemail.sendKeys(email);
	    }
	    
	    public void setpassword(String password)
	    {
	    	txtpassword.sendKeys(password);
	    }

	     public void clickonlogin()
	     {
	    	 loginbtn.click();
	     }
}
