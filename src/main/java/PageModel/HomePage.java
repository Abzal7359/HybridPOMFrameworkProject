package PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//objects
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement LoginOption;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	private WebElement RegisterOption;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//methods
	public void clickOnMYAccount() {
		myAccountDropMenu.click();
	}
	
	public void selectLoginOption() {
		LoginOption.click(); 
	}
	 public void ClickONRegister() {
		 RegisterOption.click();
	 }

}
