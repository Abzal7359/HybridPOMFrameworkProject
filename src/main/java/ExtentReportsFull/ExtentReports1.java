package ExtentReportsFull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports1 {
	public static ExtentReports generatereport() {
		ExtentReports ETR=new ExtentReports(); 
		File extentReptFile=new File(System.getProperty("user.dir")+"\\test-output\\Extent-Report\\saprkreport.html");
		ExtentSparkReporter ESR=new ExtentSparkReporter(extentReptFile);
		ESR.config().setTheme(Theme.DARK);
		ESR.config().setReportName("QAFOX");
		ESR.config().setDocumentTitle("Automation Report");
		ESR.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		ETR.attachReporter(ESR);
		Properties p=new Properties();
		File pf=new File("./src/main/java/config/cofiguration.properties");
		FileInputStream FIS=null;
		try {
			FIS=new FileInputStream(pf);
			p.load(FIS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ETR.setSystemInfo("os", System.getProperty("os.name"));
		ETR.setSystemInfo("url", p.getProperty("url"));
		ETR.setSystemInfo("Browser Name", p.getProperty("browsername"));
		ETR.setSystemInfo("validmail", p.getProperty("validmail"));
		ETR.setSystemInfo("validpassword", p.getProperty("validpassword"));
		ETR.setSystemInfo("os", System.getProperty("java.version"));
		
		return ETR;
		
		
	}
	
	
	
	
	

}
