package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baseclass.Baseclass;

public class ExtentReportManager implements ITestListener
{
	  public ExtentSparkReporter sparkreporter;
	  public  ExtentReports extent;
	  public ExtentTest test;
		
	 String repName;
	    public  void onStart(ITestContext context) 
	  {
		/*  SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		  Date dt=new Date();
		     String    currentdatestamp=df.format(dt);
		    */ 
		     
		String  timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		                 
		repName="Test-Report"+ timestamp + ".html" ;
		sparkreporter =new ExtentSparkReporter(".\\reports\\"+ repName);//specify the 
		//locatio report
		  
		sparkreporter.config().setDocumentTitle("opencart automation report");
		sparkreporter.config().setReportName("open cart Functional testing");   
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application","opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub module","Customers");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		
		  String   os=context.getCurrentXmlTest().getParameter("os");
		  extent.setSystemInfo("Operating System", os);
		  
		 String    browser=context.getCurrentXmlTest().getParameter("browser");
	    extent.setSystemInfo("Browser", browser);
	    
	    List<String> includedgroups=(context.getCurrentXmlTest().getIncludedGroups());
	  
	    if(!includedgroups.isEmpty())
	    {
	    	extent.setSystemInfo("Groups",includedgroups.toString() );
	    }
	  
	  }
	    
	    public  void onTestSuccess(ITestResult result)
	    {
	    	 test=extent.createTest(result.getClass().getName());
	    	 test.assignCategory(result.getMethod().getGroups());// to display groups in the report
	         test.log(Status.PASS,result.getName()+"got sucessfully executed    ");
	      } 
		
	    public  void onTestFailure(ITestResult result)
	    {
	    	  test=extent.createTest(result.getClass().getName());
	    	  test.assignCategory(result.getMethod().getGroups());
	    	  
	    	  test.log(Status.FAIL,result.getName()+" got failed");
	    	  test.log(Status.INFO,result.getThrowable().getMessage());
	    
	    	  try {
	     String  imgpath= new Baseclass().captureScreen(result.getName());
	       test.addScreenCaptureFromPath(imgpath);
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  e.printStackTrace();
	    	  }
	        
	      }
		
	    public void onTestSkipped(ITestResult result)
	    {
	    	test=extent.createTest(result.getClass().getName());
	    	test.assignCategory(result.getMethod().getGroups());
	      test.log(Status.SKIP, result.getThrowable()+" got skipped");
	      test.log(Status.INFO,result.getThrowable().getMessage());
	      
	      
	      }
	    
	    public void onFinish(ITestContext context)
	    {
	    	 extent.flush();
	    	 
	    }
	
	  

}
