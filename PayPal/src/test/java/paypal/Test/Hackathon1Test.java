package paypal.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import paypal.Base.Base;
import paypal.Pages.HomePage;
import paypal.Pages.SignUpPage;
import paypal.Utilities.MyListeners;

public class Hackathon1Test extends Base{
	
	public Hackathon1Test() {
		super();
	}

	
	//WebDriver Driver;
	HomePage home;
	SignUpPage sign;
	
	@Test(enabled=true)
	public void verifyUserSignUp() throws InterruptedException, IOException {
	
		
		home=new HomePage(driver);
		home.clickSignUp();
		home.selectIndivi();
		home.enterMobNo(prop.getProperty("mobno"));
		home.enterEmailPw(prop.getProperty("emailid"), prop.getProperty("password"));
		MyListeners.test.log(Status.INFO, "Email Passoword entered",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\Screenshots\\EmailPwsnap.png").build());
	
		sign=new SignUpPage(driver);
		sign.enterFields(prop.getProperty("fname"), prop.getProperty("mname"), prop.getProperty("lname"), prop.getProperty("dob"),
				prop.getProperty("ad1"), prop.getProperty("ad2"), prop.getProperty("city"), prop.getProperty("pincode"));
	
		sign.selectChkboxes();
		Assert.assertTrue(sign.validateCreate());
		MyListeners.test.log(Status.PASS, "Create Account button is displayed");

		
	}
	
	@Test(priority=1)
	public void embedIntoExcel() throws IOException {
		
		
//		int rowid=0;
//		XSSFRow row =sheet.createRow(rowid++);
		
		
		//creating header
//		sheet.createRow(0).createCell(0).setCellValue("MAIN MENU");
//		sheet.getRow(0).createCell(1).setCellValue("SUB MENU");
		
		//configuring the cellstyle
		//CellStyle style=cell1.getSheet().getWorkbook().createCellStyle();
	
	    home=new HomePage(driver);
	    home.embedMenulist();
	    MyListeners.test.log(Status.PASS, "Data entered in Excel file");
	    
		
	}
	
	@Test(priority=2)
	public void verifyBusiness() {
		
		home=new HomePage(driver);
		home.clickSignUp();
		home.selectBusiness();
		
	}

}
