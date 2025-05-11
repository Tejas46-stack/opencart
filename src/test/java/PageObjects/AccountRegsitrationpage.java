package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base_page.Basepage;

public class AccountRegsitrationpage extends Basepage
{
	
	public AccountRegsitrationpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")  WebElement txtfirstname  ;
	
	@FindBy(xpath="//input[@id='input-lastname']")  WebElement txtlastname  ;
	
	
	@FindBy(xpath="//input[@id='input-email']")  WebElement txtemail  ;
	
	@FindBy(xpath="//input[@id='input-telephone']")  WebElement txtphonenumber  ;
	
	@FindBy(xpath="//input[@id='input-password']")  WebElement txtpassword  ;
	
	@FindBy(xpath="//input[@id='input-confirm']")  WebElement txtconfirmpassword  ;
	
	@FindBy(xpath="//input[@name='agree']")  WebElement chk_policy ;
	
	@FindBy(xpath="//input[@value='Continue']")  
	WebElement btnContinue  ;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement msgConfirmation  ;
	
	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
		
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtphonenumber.sendKeys(telephone);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtconfirmpassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chk_policy.click();
	}
	public void clickonContinue()
	{
		btnContinue.click();
	}
	public String getconfirmationMsg()
	{
		try {
		return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
			}
	

}
