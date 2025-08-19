package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage{

    WebDriver driver;
    
   public Homepage(WebDriver driver){
    	
	   super(driver);
    }
	
   // finding the locators
   
   @FindBy(xpath ="//span[normalize-space()='My Account']")
   WebElement myacount;
	
   @FindBy(xpath ="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
   WebElement Resgister;
   
   @FindBy(xpath ="//a[normalize-space()='Login']")
   WebElement Loginlink;
   
   
   
   // Action methods
   
   public void clickMyaccount() {
	   myacount.click();
   }
	
   public void clickRegisterlnk() {
	   Resgister.click();
   }
   
   public void clicklogin() {
	   Loginlink.click();
   }
   
	
}
