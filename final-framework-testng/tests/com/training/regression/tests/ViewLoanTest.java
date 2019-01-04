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
import com.training.pom.ViewLoanPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewLoanTest {

	private WebDriver driver;
	private String baseUrl;
	private ViewLoanPOM loanPOM;
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
		loanPOM = new ViewLoanPOM(driver); 
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
		loanPOM.sendUserName("admin");
		loanPOM.sendPassword("1234");
		loanPOM.clickLoginBtn(); 
		loanPOM.memUsername("manzoorm");
		loanPOM.clickgrantbtn();
		loanPOM.sendamt("500");
		loanPOM.senddescrip("bonus");
		loanPOM.clicksub();
		loanPOM.finalsub();
		loanPOM.clickok();
		screenShot.captureScreenShot("member_details");
		loanPOM.viewloansub();
		screenShot.captureScreenShot("loan_view");
		
		
	}
}
