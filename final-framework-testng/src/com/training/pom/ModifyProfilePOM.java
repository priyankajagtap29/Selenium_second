package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModifyProfilePOM {
private WebDriver driver; 
	
	public ModifyProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(className="button")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//img[contains(@src,'image=quickAccess_updateProfile')]")
	private WebElement myprofile;
	
	@FindBy(id="modifyButton")
	private WebElement modifybtn;
	
	@FindBy(xpath="//input[@fieldname='address']")
	private WebElement address;
	
	@FindBy(id="saveButton")
	private WebElement sendsubmit;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickmyprofile() {
		this.myprofile.click(); 
	}
	public void modifybtn()
	{
		this.modifybtn.click();
	}
	
	public void changeadd(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}

	public void sendsubmit() {
		this.sendsubmit.click();
		
	}
}
