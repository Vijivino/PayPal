package paypal.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	WebDriver driver;
	
	@FindBy (id="paypalAccountData_firstName")
	WebElement fname;
	@FindBy (id="paypalAccountData_middleName")
	WebElement mname;
	@FindBy (id="paypalAccountData_lastName")
	WebElement lname;
	@FindBy (id="paypalAccountData_dob")
	WebElement dob;
	@FindBy (id="paypalAccountData_address1_0")
	WebElement address1;
	@FindBy (id="paypalAccountData_address2_0")
	WebElement address2;
	@FindBy (id="paypalAccountData_city_0")
	WebElement city;
	@FindBy (id="dropdownMenuButton_paypalAccountData_state_0")
	WebElement state;
	@FindBy (id="smenu_item_Delhi (NCT)")
	WebElement delhi;
	@FindBy (id="paypalAccountData_zip_0")
	WebElement postcode;
	@FindBy (xpath="//label[@for='paypalAccountData_oneTouchCheckbox']")
	WebElement chkbox1;
	@FindBy (xpath="//label[@for='paypalAccountData_marketingOptIn']")
	WebElement chkbox2;
	@FindBy (xpath="//label[@for='paypalAccountData_termsAgree']")
	WebElement chkbox3;
	@FindBy(id="paypalAccountData_emailPassword")
	WebElement create;
	

	
	public SignUpPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void enterFields(String fn,String mn,String ln,String date,String ad1,String ad2,String citys,String pin) 
	{
		fname.sendKeys(fn);
		mname.sendKeys(mn);
		lname.sendKeys(ln);
		dob.sendKeys(date);
		address1.sendKeys(ad1);
		address2.sendKeys(ad2);
		city.sendKeys(citys);
		state.click();
		delhi.click();
		postcode.sendKeys(pin);
	}
	
	public void selectChkboxes() {
		
		chkbox1.click();
		chkbox2.click();
		chkbox3.click();
		
	}
	
	public boolean validateCreate() {
		boolean displayed = create.isDisplayed();
		return displayed;
	}
}
