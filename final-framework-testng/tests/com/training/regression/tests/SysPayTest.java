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
import com.training.pom.SysPayPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SysPayTest {

	private WebDriver driver;
	private String baseUrl;
	private SysPayPOM sysPOM;
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
		sysPOM = new SysPayPOM(driver); 
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
		sysPOM.sendUserName("manzoorm");
		sysPOM.sendPassword("manzoor1");
		sysPOM.clickLoginBtn(); 
		sysPOM.accounttab();
		sysPOM.clicksyspay();
		sysPOM.sendamt("500");
		sysPOM.seltrans();
		sysPOM.senddescrip("bonus");
		sysPOM.clicksub();
		sysPOM.finalsub();
		sysPOM.clickaccinfo();
		screenShot.captureScreenShot("payment_view");
		
		
	}
}
