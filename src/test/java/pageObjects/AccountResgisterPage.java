package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountResgisterPage extends BasePage{

	public AccountResgisterPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfrmPass;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPrivacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement clckContinuebtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	

	
	public void setFirstname(String name) {
		txtFirstname.sendKeys(name);
	}
	
	public void setLasstname(String lastname) {
		txtLastname.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhonenum(String phonenum) {
		txtTelephone.sendKeys(phonenum);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfmPassword(String cnfpassword) {
		txtConfrmPass.sendKeys(cnfpassword);
	}
	
	public void setPrivacy() {
		chkPrivacyPolicy.click();
	}
	
	public void clickbtn() {
		clckContinuebtn.click();
	}

	
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
		
		
	}
}


