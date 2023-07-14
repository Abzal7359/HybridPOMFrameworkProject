package test1;

import static org.testng.Assert.*;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageModel.HomePage;
import basic.base1;
import config.RegisterPage;
import utils.utilities;

public class RegistrationTest extends base1{
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		
		driver=intialise(prop.getProperty("browsername")) ;
		
		HomePage hp=new HomePage(driver);
		hp.clickOnMYAccount();//click on Account
		hp.ClickONRegister();//click on register option 
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void registerWithonly_Mandatoryfields() throws InterruptedException {
		RegisterPage rp=new RegisterPage(driver);
		rp.EnterFirstName(data.getProperty("firstname"));
		rp.EnterLastName(data.getProperty("Lastname"));
		rp.EnterEmail(utilities.TimeStamp()+"@gmail.com");
		rp.Enterphonenum(data.getProperty("phone"));
		rp.inputpassword(data.getProperty("password"));
		Thread.sleep(1000);//this sleep to see the what happening it typing or not for my sake and happiness
		rp.InputConfirmPassword(data.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		rp.clickOnContinue();
		String ExpectedConfirmation="Your Account Has Been Created!";
		assertEquals(rp.ActualRegisterMessage(), ExpectedConfirmation);
		
	}
	
	
	@Test(priority=1)
	public void verifyRegisterdAccountByprovidingMandatoryFields() {
		RegisterPage rp=new RegisterPage(driver);
		rp.EnterFirstName(data.getProperty("firstname"));
		rp.EnterLastName(data.getProperty("Lastname"));
		rp.EnterEmail("O170700@rguktong.ac.in");
		rp.Enterphonenum(data.getProperty("phone"));
		rp.inputpassword(data.getProperty("password"));
		//this sleep to see the what happening it typing or not for my sake and happiness
		rp.InputConfirmPassword(data.getProperty("password"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		rp.clickOnContinue();
		String actualerrormssg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String Expectederrormssg="Warning: E-Mail Address is already registered!";	
		assertEquals(actualerrormssg, Expectederrormssg);
		
	}
	
	
	@Test(priority = 2)
	public void registerWith_ALLfields() throws InterruptedException {
		RegisterPage rp=new RegisterPage(driver);
		rp.EnterFirstName(data.getProperty("firstname"));
		rp.EnterLastName(data.getProperty("Lastname"));
		rp.EnterEmail(utilities.TimeStamp()+"@gmail.com");
		rp.Enterphonenum(data.getProperty("phone"));
		rp.inputpassword(data.getProperty("password"));
		Thread.sleep(1000);//this sleep to see the what happening it typing or not for my sake and happiness
		rp.InputConfirmPassword(data.getProperty("password"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		rp.clickOnContinue();
		String ExpectedConfirmation="Your Account Has Been Created!";
		assertEquals(rp.ActualRegisterMessage(), ExpectedConfirmation);
		
	}
	
	

}
