package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ViewPaymentPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewPaymentTest {

	private WebDriver driver;
	private String baseUrl;
	private ViewPaymentPOM payPOM;
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
		payPOM = new ViewPaymentPOM(driver); 
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
	public void validLoginTest() throws InterruptedException  {
		payPOM.sendUserName("admin");
		payPOM.sendPassword("1234");
		payPOM.clickLoginBtn(); 
		payPOM.memUsername("manzoorm");
		payPOM.clickpaybtn();
		payPOM.sendamt("500");
		payPOM.seltrans();
		payPOM.senddescrip("bonus");
		payPOM.clicksub();
		payPOM.finalsub();
		payPOM.logoutfunc();
		payPOM.clickok();
		payPOM.sendUserName("manzoorm");
		payPOM.sendPassword("manzoor1");
		payPOM.clickLoginBtn();
		payPOM.accounttab();
		payPOM.clickaccinfo();
		screenShot.captureScreenShot("pay_view");
		
		
	}
}
