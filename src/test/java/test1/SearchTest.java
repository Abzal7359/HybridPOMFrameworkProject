package test1;

import static org.testng.Assert.*;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basic.base1;

public class SearchTest extends base1 {
	public WebDriver driver;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {

//		loadPropertiesFile();
		driver=intialise(prop.getProperty("browsername")) ;
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void verifyWithValidSearchProduct() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//		Thread.sleep(3000);
		String actualshown=driver.findElement(By.xpath("//a[normalize-space()='iPhone']")).getText();
		String ExpectedShown="iPhone";
		assertEquals(actualshown, ExpectedShown);
	}
	
	@Test(priority = 1)
	public void verifyWithInvalidSearchProduct() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Honda");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String actualshown=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		String ExpectedShown="There is no product that matche the search criteria.";
		assertEquals(actualshown, ExpectedShown);
	}
	
	@Test(priority = 2)
	public void verifyWithBlankSearchProduct() {
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String actualshown=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		String ExpectedShown="There is no product that matches the search criteria.";
		assertEquals(actualshown, ExpectedShown);
	}

}
