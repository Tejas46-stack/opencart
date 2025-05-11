package Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws Exception
	{
		String path="F:\\final\\depth\\selenium\\opencart\\testData\\Userdata2.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getrowcount("Sheet1");
		
		int totalcols=xlutil.getcellcount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for (int i = 1; i <=totalrows; i++) //1 read the data from row
		{
			for (int j = 0; j < totalcols; j++) //0
			{
				logindata[i-1][j]=xlutil.getcellData("Sheet1", i, j);
			}
			
		}
		return logindata;
		
	}

}
