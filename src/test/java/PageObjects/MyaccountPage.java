package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base_page.Basepage;

public class MyaccountPage extends Basepage 
{
	public MyaccountPage(WebDriver driver)
	{ 
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutbtn;
	
	public boolean isMyaccountPageExists()
	{
		try {
		   return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		   
		
	}
	
	public void clicklogout()
	{
		logoutbtn.click();
		
	}

}
