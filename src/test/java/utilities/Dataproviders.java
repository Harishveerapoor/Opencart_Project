package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class Dataproviders {

    @DataProvider(name = "LoginData")
	
	public String[][] getData() throws IOException
	{
	    // Taking Excel file from testData folder
	    String path = ".\\testdata\\OpencartExcel.xlsx";

	    // Creating an object for Excel utility
	    ExcelUtility xlutil = new ExcelUtility(path);

	    // Get row and column counts
	    int totalrows = xlutil.getRowcount("Sheet1");
	    int totalcols = xlutil.getCellcount("Sheet1", 1);

	    // Create two-dimensional array to store data
	    String logindata[][] = new String[totalrows][totalcols];

	    // Read the data from Excel and store in array
	    for (int i = 1; i <= totalrows; i++)   // i → rows
	    {
	        for (int j = 0; j < totalcols; j++)   // j → cols
	        {
	            logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	        }
	    }

	    // Returning 2D array
	    return logindata;
	}

}
