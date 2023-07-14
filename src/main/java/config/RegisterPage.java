package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement Firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement Lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailId;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement mobile;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordenter;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmpasswordEnter;
	
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	private WebElement continuebutton;
	
	@FindBy(css = "div[id='content'] h1")
	private WebElement RegisterConfirmMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//methods 
	
	public void EnterFirstName(String First) {
		Firstname.sendKeys(First);
	}
	public void EnterLastName(String Last) {
		Lastname.sendKeys(Last);
	}
	public void EnterEmail(String email) {
		emailId.sendKeys(email);
	}
	public void Enterphonenum(String mobiletext) {
		mobile.sendKeys(mobiletext);
	}
	public void inputpassword(String password) {
		passwordenter.sendKeys(password);
	}
	public void InputConfirmPassword(String CFP) {
		confirmpasswordEnter.sendKeys(CFP);
	}
	
	public void clickOnContinue() {
		continuebutton.click();
	}
	public String ActualRegisterMessage() {
		return(RegisterConfirmMessage.getText());
	}

}
