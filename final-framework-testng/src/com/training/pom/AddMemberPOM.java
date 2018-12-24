package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddMemberPOM {
private WebDriver driver; 
	
	
		public AddMemberPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(id="cyclosUsername")
		private WebElement userName; 
		
		@FindBy(id="cyclosPassword")
		private WebElement password;
		
		@FindBy(className="button")
		private WebElement loginBtn; 
		
		@FindBy(id="memberUsername")
		private WebElement memusername;
		
		@FindBy(xpath="//input[contains(@linkurl,'changeMemberGroup')]")
		private WebElement permbutton;
		
		@FindBy(name="newGroupId")
		private WebElement newgroup;
		
		@FindBy(id="comments")
		private WebElement comments;
		
		@FindBy(xpath="//input[@value='Submit']")
		private WebElement submitbtn;
		
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
		
		public void memUsername(String memusername) {
			this.memusername.clear();
			this.memusername.sendKeys(memusername);
		}
		
		public void clickpermbtn() {
			this.permbutton.click(); 
		}
		
		public void selgroupid() {
		  Select sel = new Select(newgroup); 
		  sel.selectByVisibleText("Full members");
		}

		

		public void sendcomment(String comments) {
			this.comments.sendKeys(comments);

			
		}

		public void submitbtn() {
			this.submitbtn.click();
			
		}
}
