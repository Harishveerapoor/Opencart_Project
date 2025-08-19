package testCasses;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import pageObjects.AccountResgisterPage;
import pageObjects.BasePage;
import pageObjects.Homepage;
import testBase.BaseClass;

@Test
public class TC_AccountResgistionTest extends BaseClass{

	// part -7
	@Test(groups={"Regression","Master"})

	
	public void verify_account_Register() {
		// Homepage
		
		try {
		logger.info("*********---Starting TC_AccountResgitionTest---*******");
		
		Homepage hp=new Homepage(driver);
		hp.clickMyaccount();
		logger.info("*********---Clicked Myaccount---*******");
		
		hp.clickRegisterlnk();
		logger.info("*********---Clicked Register Link---*******");
		
		// AccountRegister page
		
		AccountResgisterPage acpage=new AccountResgisterPage(driver);
		
		logger.info("*********---Start providing customer details---*******");
		
		acpage.setFirstname(randomString().toUpperCase());
		acpage.setLasstname(randomString().toUpperCase());
		acpage.setEmail(randomString()+"@gmail.com");
		acpage.setPhonenum(randomNumber());
		
		String password=randomAphaNumaric();  
		
		acpage.setPassword(password);
		acpage.setConfmPassword(password);
		
		acpage.setPrivacy();
		acpage.clickbtn();
		
		logger.info("*********---Validating msg Confirmation---*******");
		
		String confmsg=acpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed....");
			logger.debug("debug logs....");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*********---Ending of TC_AccountResgitionTest---*******");
				
	}
	

}
