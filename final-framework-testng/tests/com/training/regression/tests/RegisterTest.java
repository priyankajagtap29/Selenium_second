package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTest {
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM regPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		regPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		regPOM.clickregBtn(); 
		regPOM.sendUserName("manzoorme");
		regPOM.sendFullname("manzoorme");
		regPOM.sendEmail("manzoor21@gmail.com");
		regPOM.sendgender();
		regPOM.otherdetails("Bangalore","560054","Bangalore","9876543210","9876543210","9876543210","www.google.com");
		regPOM.sendpassword("manzoor1");
		regPOM.sendconfirmpassword("manzoor1");
		TimeUnit.MINUTES.sleep(1);
		regPOM.sendsubmit();
		screenShot.captureScreenShot("Registration");
	}

}
