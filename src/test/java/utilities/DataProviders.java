package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//Dataprovider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException//string type array --[row][col]
	{
		String path = ".\\testData\\Book1.xlsx"; //taking excel file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcell = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcell];//created for two dimension array which can store the data user and password
		
		for(int r=1;r<=totalrows;r++) //1   //read the data from xl storing in two deminsional array
		{
			for(int c=0;c<totalcell;c++)// r is rows, c is cell
			{
			 logindata[r-1][c]=xlutil.getCellData("Sheet1", r, c); //1,0
			}
		}
		return logindata; //Returning two dimensional array
		
	}
}
