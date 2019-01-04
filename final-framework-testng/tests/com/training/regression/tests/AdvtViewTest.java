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
import com.training.pom.AdvtViewPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdvtViewTest {

	private WebDriver driver;
	private String baseUrl;
	private AdvtViewPOM advPOM;
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
		advPOM = new AdvtViewPOM(driver); 
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
		advPOM.sendUserName("admin");
		advPOM.sendPassword("1234");
		advPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		advPOM.memUsername("manzoorm");
		advPOM.clickmngadvt();
		advPOM.insnewadvt();
		advPOM.sendtitle("New offer2");
		advPOM.selcategory();
		advPOM.sendprice("7");
		advPOM.chkntexpirable();
		advPOM.senddescrip();
		advPOM.clicksavebtn();
		advPOM.clickOK();
		advPOM.logoutfunc();
		advPOM.clickok();
		advPOM.sendUserName("manzoorm");
		advPOM.sendPassword("manzoor1");
		advPOM.clickLoginBtn();
		advPOM.personaltab();
		advPOM.clickadvts();
		screenShot.captureScreenShot("advt_view");
		
	}
}
