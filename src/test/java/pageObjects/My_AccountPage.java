package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_AccountPage extends BasePage {

	public My_AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[normalize-space()='Qafox.com']")
	WebElement logo;
	
	// part -6
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;
	
	
	public boolean isMylogoexist() {
		try {
		return (logo.isDisplayed());
		
		}
		catch(Exception e) {
			return false;
		}
	}

	public  void clickLogout() {
		lnklogout.click();
	}
	
}
