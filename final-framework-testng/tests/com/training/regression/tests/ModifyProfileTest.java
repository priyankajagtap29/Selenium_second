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
import com.training.pom.ModifyProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ModifyProfileTest {
	private WebDriver driver;
	private String baseUrl;
	private ModifyProfilePOM profilePOM;
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
		profilePOM = new ModifyProfilePOM(driver); 
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
	public void validLoginTest() {
		profilePOM.sendUserName("manzoorme");
		profilePOM.sendPassword("manzoor1");
		profilePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("homepage");
		profilePOM.clickmyprofile();
		profilePOM.modifybtn();
		profilePOM.changeadd("yeshwanthapur");
		profilePOM.sendsubmit();
	}
}
