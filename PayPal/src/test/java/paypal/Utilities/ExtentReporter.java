package paypal.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import paypal.Base.Base;

public class ExtentReporter extends Base{
	

	public static ExtentReports generateReport() throws IOException {
		
		ExtentReports exReports=new ExtentReports();
		
		File reportFile=new File(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReport "+timeStamp()+".html");
		//File reportFile=new File(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(reportFile);
		//customize reports 
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("PayPal Test Automation Result");
		sparkReporter.config().setDocumentTitle("PP Test Result");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		//attaching the customized sparkReport on exReport
		exReports.attachReporter(sparkReporter);
		
		
		exReports.setSystemInfo("Application URL ",("https://www.paypal.com/in/home") );
		exReports.setSystemInfo("Browser Name ",("Chrome"));
		
		//add some test environment info from the machine
		  //System.getProperties().list(System.out); //it will print all the properties with name
		exReports.setSystemInfo("Operating System ", System.getProperty("os.name"));
		exReports.setSystemInfo("UserName ", System.getProperty("user.name"));
		exReports.setSystemInfo("Java Version ", System.getProperty("java.version"));
		
		return exReports;	
		
	}

}
