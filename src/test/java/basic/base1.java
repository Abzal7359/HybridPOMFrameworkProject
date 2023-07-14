package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import utils.utilities;

public class base1 {
	
	WebDriver driver;
	public Properties prop;
	public Properties data;
	
	
	public base1() {
		
		prop=new Properties();
		File inputFile=new File("./src/main/java/config/cofiguration.properties");
//		FileInputStream FIS;
		try {
			FileInputStream FIS = new FileInputStream(inputFile);
			try {
				prop.load(FIS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//second data
		
		data=new Properties();
		
		File ip=new File("./src/main/java/config/testdata.properties");
			
		
		
		
		try {
			FileInputStream FIS2= new FileInputStream(ip);
			try {
				data.load(FIS2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	
	
	
	
	
	public WebDriver intialise(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICT_TIME));
		driver.get(prop.getProperty("url"));
	
		return driver;
		
	}

}
