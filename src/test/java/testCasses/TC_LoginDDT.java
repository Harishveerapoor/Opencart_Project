package testCasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.My_AccountPage;
import testBase.BaseClass;
import utilities.Dataproviders;

public class TC_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = Dataproviders.class,groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {

		
		// part -6 All // run in master.xml
		
	    logger.info("******-----Starting of TC_LoginDDT-----**********");

	    try {
	        // Homepage	
	        Homepage hp = new Homepage(driver);
	        hp.clickMyaccount();
	        hp.clicklogin();

	        // LoginPage  // LoginPage // its different here part-->6
	        LoginPage lp = new LoginPage(driver);
	        lp.setEmail(email);   // ⚠️ if "email" is already value from Excel, remove p.getProperty()
	        lp.setPassword(pwd);  // ⚠️ same here
	        lp.clickLogin();

	        // MyAccountPage
	        My_AccountPage macc = new My_AccountPage(driver);
	        boolean targetPage = macc.isMylogoexist();

	        /*
	         * Data is valid   - login success → test pass → logout
	         *                   login failed → test fail
	         *
	         * Data is invalid - login success → test fail → logout
	         *                   login failed → test pass
	         */

	        
	     // 1]--> Data is valid - login success - test pass - logout //- login failed - test fail
	        
	        if (exp.equalsIgnoreCase("Valid")) {
	            if (targetPage) {
	                macc.clickLogout();
	                Assert.assertTrue(true, "Login successful with valid data (PASS)");
	            } else {
	                Assert.fail("Login failed with valid credentials (FAIL)");
	            }
	        }

	        
	     // 2]--> Data is invalid - login success - test fail - logout //-login failed - test pass
	        
	        
	        if (exp.equalsIgnoreCase("Invalid")) {  // equalsIgnoreCase will help to valid even i written words in small or captil letter it consider in the string " "
	            if (targetPage) {
	            	
	                macc.clickLogout(); // we need to put this 1st becu assertion will goes 1st then next code not excuites thats why
	                Assert.fail("Login successful with invalid data (FAIL)");
	                
	            } 
	            else {
	                Assert.assertTrue(true, "Login failed with invalid credentials (PASS)");
	            }
	        }

	    } catch (Exception e) {
	        Assert.fail("Test execution failed due to exception: " + e.getMessage(), e);
	    }

	    Thread.sleep(2000);
	    logger.info("******-----End of TC_LoginDDT-----**********");
	}


}
