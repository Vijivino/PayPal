package paypal.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	
	public Base() {
		prop=new Properties();
		try {
		FileInputStream fis=new FileInputStream("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\config.properties");
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@BeforeMethod
	public void launch() {

		driver=new ChromeDriver();
		driver.get("https://www.paypal.com/in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}

	public static String timeStamp() {
		String time = new SimpleDateFormat("dd.MM.yyy-HH.mm.ss").format(new Date());
		return time;	
	}
	
	

	@AfterMethod
	public void getcreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\Screenshots\\"+result.getName()+".png";
			try {
				FileUtils.copyFile(source, new File(path));

			} catch (IOException e) {
				e.printStackTrace();
			} 
			//driver.quit();
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\Screenshots\\"+result.getName()+".png";
			try {
				FileUtils.copyFile(source, new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			} 
			//driver.quit();
		}
	}
	
	
	}
