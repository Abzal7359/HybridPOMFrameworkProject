package listenersfull;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReportsFull.ExtentReports1;

public class Listener1 implements ITestListener {
	ExtentReports extent;
	ExtentTest extenttest;

	
	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReports1.generatereport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extenttest = extent.createTest(result.getName());
		extenttest.log(Status.INFO,result.getName()+" Test Start" );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extenttest.log(Status.PASS,result.getName()+" Test Success" );
		
		
		
//		System.out.println(result.getName()+"Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Date d=new Date();
		TakesScreenshot SCR= (TakesScreenshot) driver;
		File SourceFile=SCR.getScreenshotAs(OutputType.FILE);
//		String t=(d.toString().replace(" ", "-").replace(":", "_")+result.getName()+".jpg");
		String filepath=System.getProperty("user.dir")+"\\screenshots"+result.getName()+".png"; 
		File DestFile=new File(filepath);
		try {
			FileUtils.copyFile(SourceFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.addScreenCaptureFromPath(filepath);
		extenttest.log(Status.FAIL,result.getName()+" Test FAILURE" );
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\test-output\\Extent-Report\\saprkreport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
