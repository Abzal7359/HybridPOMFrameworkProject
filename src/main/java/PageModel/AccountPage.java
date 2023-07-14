package PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	private WebElement LoginAccountConfiramtion;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//methods 
	public Boolean AccountLoginSuccesCheck() {
		return(LoginAccountConfiramtion.isDisplayed());
	}
	

}
