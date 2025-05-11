package Baseclass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Baseclass 
{
public static WebDriver driver;
	
	@BeforeMethod(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//Loading config.properties file
		FileReader
		 file=new FileReader("F:\\final\\depth\\selenium\\opencart\\config.properties");
		Properties p=new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		case "edge":driver=new EdgeDriver();break;
		default:System.out.println("Invaluid browser");return;
		
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(p.getProperty("appurl"));// reading the data from property file
		
	}
	
	@AfterMethod(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomeString()
	{
		String    generatestring= RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	
	public String randomeNumber()
	{
		String    generatenumber=RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	public String randomAlphanumeric()
	{
	String	   generatedstring=RandomStringUtils.randomAlphabetic(3);
	String    generatenumber = RandomStringUtils.randomNumeric(3);
	return (generatedstring+generatenumber);
	}
	
	 public String captureScreen(String tname)
	 {
	String timestamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		 
   TakesScreenshot takescreenshot=(TakesScreenshot)driver;
  File      sourcefile= takescreenshot.getScreenshotAs(OutputType.FILE);   
String targerFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+timestamp+".png";
		File targetFile=new File(targerFilePath) ;
		
		sourcefile.renameTo(targetFile);
		
		return targerFilePath;
		
		

	
	 }

}
