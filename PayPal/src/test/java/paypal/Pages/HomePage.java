package paypal.Pages;


import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class HomePage {

	WebDriver driver;

	@FindBy (id="hero-signup")
	WebElement signupBtn;
	@FindBy (id="next-btn")
	WebElement nextBtn;
	@FindBy (id="paypalAccountData_phone")
	WebElement mobNo;
	@FindBy (id="paypalAccountData_submit")
	WebElement nextBtn2;
	@FindBy (id="paypalAccountData_email")
	WebElement email;
	@FindBy (id="paypalAccountData_password")
	WebElement password;
	@FindBy (id="paypalAccountData_emailPassword")
	WebElement submit;
	@FindBy (xpath="//nav[@id='main-menu']/ul/li")
	List<WebElement> menulist;
	@FindBy (xpath="//a[text()='INDIVIDUAL']")
	WebElement individual;
	@FindBy (xpath="//div[@class='_submenu-cols_aml6f_482']/ul/li")
	List<WebElement> submenu1;
	@FindBy (xpath="//a[text()='USEFUL INFO']")
	WebElement useful;
	@FindBy (xpath="//a[text()='Online Security']")
	WebElement security;
	@FindBy(tagName = "body")
	WebElement content;


	public HomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignUp() {
		signupBtn.click();

	}

	public void selectIndivi() {
		nextBtn.click();
	}

	public void enterMobNo(String Mno) throws InterruptedException {
		mobNo.sendKeys(Mno);
		nextBtn2.click();
		Thread.sleep(2000);
	}

	public void enterEmailPw(String emailid,String pw) throws IOException {
		email.sendKeys(emailid);
		password.sendKeys(pw);
		File source=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\Screenshots\\EmailPwsnap.png");
		FileUtils.copyFile(source, destination);
		submit.click();
	}

	public void embedMenulist() throws IOException {

		String data1 = " " ;

		FileOutputStream ExcelFile = new FileOutputStream(
				new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\MenuSubMenu.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Menu");
		for(int i=0;i<menulist.size();i++) {
			sheet.createRow(i).createCell(0).setCellValue(menulist.get(i).getText());
			System.out.println(menulist.get(i).getText());
		}

		Actions a=new Actions(driver);
		a.moveToElement(individual).perform();

		for(int i=0;i<submenu1.size();i++) {
			data1=data1.concat(submenu1.get(i).getText());
			//sheet.getRow(0).createCell(1).setCellValue(sub1.get(i).getText());
			System.out.println(submenu1.get(i).getText());
		}
		System.out.println("data :"+data1);
		sheet.getRow(0).createCell(1).setCellValue(data1);

		workbook.write(ExcelFile);
		Assert.assertNotNull(ExcelFile);
		workbook.close();
	}


	public void checkExcel() {



	}

	public void navigateUsefulInfo() {

		Actions a=new Actions(driver);
		a.moveToElement(useful).perform();

	}

	public void clickonlineSec() throws InterruptedException {
		security.click();
		Thread.sleep(2000);
	}

	public void embedtoText() throws IOException, InterruptedException {

		String data = content.getText();
		System.out.println(data);
		Thread.sleep(2000);
		String filepath=("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\onlinesecurity.txt");
		File FC = new File(filepath);
		FC.createNewFile();

		FileWriter FW = new FileWriter(filepath);
		BufferedWriter BW = new BufferedWriter(FW);

		BW.write(data);
		Assert.assertNotNull(BW);
		BW.close();	

	}

	public void selectBusiness() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('input#business-selected','::before').click()");
		nextBtn.click();
	}

	public void compSnap() throws IOException, InterruptedException {
		BufferedImage expectedImage=ImageIO.read(new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\ExpSnap.png"));

		//take screenshot 
		Thread.sleep(3000);
		File source=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\Actsnap.png");
		FileUtils.copyFile(source, destination);
		//read the actual screenshot
		BufferedImage actualImage=ImageIO.read(new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\Actsnap.png"));
		//compare the screenshots
		ImageDiffer imagediff=new ImageDiffer();
		ImageDiff diff=imagediff.makeDiff(expectedImage, actualImage);

		if(diff.hasDiff()==true) {
			System.out.println("Screenshots are Not same");
		}else {
			System.out.println("Screenshots are same");
		}


	}




}
