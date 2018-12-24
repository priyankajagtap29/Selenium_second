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
import com.training.pom.AddMemberPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddMemberTest {
	private WebDriver driver;
	private String baseUrl;
	private AddMemberPOM memPOM;
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
		memPOM = new AddMemberPOM(driver); 
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
	public void memaddTest() throws InterruptedException {
		memPOM.sendUserName("admin");
		memPOM.sendPassword("1234");
	    memPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("Second");
		memPOM.memUsername("manzoorme");
		Thread.sleep(1000);
		memPOM.clickpermbtn();
		memPOM.selgroupid();
		memPOM.sendcomment("access given");
		memPOM.submitbtn();
		screenShot.captureScreenShot("memberadded");
	}

}


