package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base_page.Basepage;

public class Home_Page extends Basepage
{
	WebDriver driver;
	
	public Home_Page(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")  WebElement myaccountlink;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register_link;
	
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement linklogin;
	
	public void clickmyaccount()
	{
		myaccountlink.click();
	}
	
	public void clickregister()
	{
		register_link.click();
	}
	
	public void clicklogin()
	{
		linklogin.click();
	}

}
