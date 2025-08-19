package testCasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.My_AccountPage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass {
	
	
	// we need put Test annotataion othert wise xml file wont be run  and import from testng
	
	// part -7
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
	logger.info("********----Staring of TC_LoginTest---********");	
		
	try {	
	// Homepage	
	Homepage hp=new Homepage(driver);
	hp.clickMyaccount();
	hp.clicklogin();

	// Login
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	//Myaccount
	
	My_AccountPage macc=new My_AccountPage(driver);
	boolean targetPage=macc.isMylogoexist();
	
//	Assert.assertTrue(targetPage);
	Thread.sleep(4000);
	Assert.assertEquals(targetPage, true, "Login failed");
	}
	catch(Exception e) {
		Assert.fail();
	}
	
	logger.info("********----Ending of TC_LoginTest---********");
	
}
}