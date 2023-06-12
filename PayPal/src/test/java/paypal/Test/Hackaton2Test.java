package paypal.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import paypal.Base.Base;
import paypal.Pages.HomePage;
import paypal.Utilities.MyListeners;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Hackaton2Test extends Base{
	
	HomePage home;
	
	@Test
	public void embedIntoText() throws IOException, InterruptedException {
		
		home=new HomePage(driver);
		home.navigateUsefulInfo();
		home.clickonlineSec();
		home.embedtoText();
		MyListeners.test.log(Status.PASS, "Data entered in Text file");
		
	}
	
	@Test
	public void compareSnap() throws IOException, InterruptedException {
		
		home=new HomePage(driver);
		home.compSnap();
		MyListeners.test.log(Status.INFO,"Expected snap ", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\ExpSnap.png").build());
		MyListeners.test.log(Status.INFO,"Actual snap ", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\PayPal\\src\\test\\resources\\ActSnap.png").build());
	    MyListeners.test.log(Status.PASS, "Screenshots are compared ");
		
	}
	

}
