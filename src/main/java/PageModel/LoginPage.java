package PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement LoginEnterMail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement LoginEnterpassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginButtonClick;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement ivalidEmailOrPassWarning;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void Entermail(String email) {
		 LoginEnterMail.sendKeys(email);
	}
	
	public void Enterpassword(String password) {
		LoginEnterpassword.sendKeys(password);
	}
	
	public void ClickLoginButton() {
		LoginButtonClick.click();
	}
	
	public String actualwarningdisplayed() {
		return(ivalidEmailOrPassWarning.getText());
	}

}
