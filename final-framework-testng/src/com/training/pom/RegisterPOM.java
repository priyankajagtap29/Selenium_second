package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"loginRegistrationDiv\"]/input")
	private WebElement regBtn; 
	
	@FindBy(name="member(user).username")
	private WebElement userName; 
	
	@FindBy(name="member(name)")
	private WebElement fullname;
	
	@FindBy(name="member(email)")
	private WebElement email;
	
	@FindBy(name="_radio_2")
	private WebElement sendgen; 
	
	@FindBy(xpath="//input[@fieldname='address']")
	private WebElement address;
	
	@FindBy(xpath="//input[@fieldname='postalCode']")
	private WebElement pincode;
	
	@FindBy(xpath="//input[@fieldname='city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@fieldname='phone']")
	private WebElement number;
	
	@FindBy(xpath="//input[@fieldname='mobilePhone']")
	private WebElement mobile;
	
	@FindBy(xpath="//input[@fieldname='fax']")
	private WebElement fax;
	
	@FindBy(xpath="//input[@fieldname='url']")
	private WebElement url2;
	
	@FindBy(name="member(user).password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confpassword;
	
	@FindBy(id="saveButton")
	private WebElement sendsubmit;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendFullname(String fullname) {
		this.fullname.clear(); 
		this.fullname.sendKeys(fullname); 
	}


	public void clickregBtn() {
		
		this.regBtn.click();
	}

	public void sendEmail(String email) {
			this.email.sendKeys(email);
			}

	public void sendpassword(String password) {
		this.password.sendKeys(password);
	}

	public void sendconfirmpassword(String confpassword) {
		this.confpassword.sendKeys(confpassword);
		
	}

	public void sendgender() {
		this.sendgen.click();
		
	}

	public void otherdetails(String address, String pincode, String city, String number, String mobile,
			String fax, String url2) {
		this.address.sendKeys(address);
		this.pincode.sendKeys(pincode);
		this.city.sendKeys(city);
		this.number.sendKeys(number);
		this.mobile.sendKeys(mobile);
		this.fax.sendKeys(fax);
		this.url2.sendKeys(url2);
		
	}

	public void sendsubmit() {
		this.sendsubmit.click();
		
	}
}

