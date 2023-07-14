package test1;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageModel.AccountPage;
import PageModel.HomePage;
import PageModel.LoginPage;
import basic.base1;
import utils.utilities;

public class LoginTest extends base1{
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver=intialise(prop.getProperty("browsername"));
		//creating object for page model  class
		HomePage homepage=new HomePage(driver);
		
		homepage.clickOnMYAccount();
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		homepage.selectLoginOption();
//		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1,dataProvider = "Abzal")
	public void verifyLoginWithValidCredemtials(String username,String password) {
		
		//creating object for page model  class
		LoginPage lp=new LoginPage(driver);
		
		lp.Entermail(username);
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
		lp.Enterpassword(password);
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		lp.ClickLoginButton();
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		AccountPage Ap=new AccountPage(driver);
	
		Assert.assertTrue(Ap.AccountLoginSuccesCheck(),"see mail or password");

	}
	
	
	//dataprovider of excell
	@DataProvider(name="Abzal")
	public  String[][] dp() throws IOException {
		File ef=new File("./src/main/java/config/Book1.xlsx");
		FileInputStream fis=new FileInputStream(ef);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Login");
		int numrows=sheet.getPhysicalNumberOfRows();
		int numcolumn=sheet.getRow(0).getLastCellNum();
		String[][] rawdata=new String[numrows-1][numcolumn];
		for(int i=0;i<numrows-1;i++) {
			for(int j=0;j<numcolumn;j++) {
				DataFormatter df=new DataFormatter();
				rawdata[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));	
				}
		}
		wb.close();
		fis.close();
		return rawdata;
		
	}
	
	
	


	@Test(priority = 2)
	public void verifyLoginWithInValidCredemtials() {
		LoginPage lp=new LoginPage(driver);
		lp.Entermail("O170" + utilities.TimeStamp() + "@rguktong.ac.in");
		lp.Enterpassword(data.getProperty("invalidPassword"));
		lp.ClickLoginButton();
		String ExpectWaning = data.getProperty("invalidCredentialsWaring");
		Assert.assertEquals(lp.actualwarningdisplayed(), ExpectWaning);

	}

	
	@Test(priority = 3)
	public void verifyLoginWithInValid_email() {

		LoginPage lp=new LoginPage(driver);
		lp.Entermail("O170" + utilities.TimeStamp() + "@rguktong.ac.in");
		lp.Enterpassword(prop.getProperty("validpassword"));
		lp.ClickLoginButton();
		String ExpectWaning = data.getProperty("invalidCredentialsWaring");
		Assert.assertEquals(lp.actualwarningdisplayed(), ExpectWaning);

	}

	
	@Test(priority = 4)
	public void verifyLoginWithInValid_password() {
		LoginPage lp=new LoginPage(driver);
		lp.Entermail(prop.getProperty("validmail"));
		lp.Enterpassword(data.getProperty("invalidPassword"));
		lp.ClickLoginButton();
		String ExpectWaning = data.getProperty("invalidCredentialsWaring");
		Assert.assertEquals(lp.actualwarningdisplayed(), ExpectWaning);

	}

}
