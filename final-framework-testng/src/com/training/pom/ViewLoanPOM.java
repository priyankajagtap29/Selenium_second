package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewLoanPOM {
	private WebDriver driver; 
	
	public ViewLoanPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//input[contains(@linkurl,'grantLoan?memberId=12')]")
	private WebElement grantloanbtn;
	
	@FindBy(id="amount")
	private WebElement amt;
	
	@FindBy(name="loan(description)")
	private WebElement textdescr;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")
	private WebElement subbtn;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td/input")
	private WebElement finalsubmit;
	
	@FindBy(xpath="//input[contains(@linkurl,'searchLoans?memberId=12')]")
	private WebElement searchloanbtn;

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
	
	public void clickgrantbtn() {
		this.grantloanbtn.click(); 
	}
	
	public void sendamt(String amt) {
		this.amt.sendKeys(amt);
	}
	
	public void senddescrip(String descrip) {
		this.textdescr.sendKeys(descrip);
	}
	  
	public void clicksub() {
	this.subbtn.click();
	}
	
	public void finalsub() {
		this.finalsubmit.click();
	}
	
	public void clickok() {
		Alert al=driver.switchTo().alert();
		al.accept();
		//al.dismiss();	
	}
	
	public void viewloansub() {
		this.searchloanbtn.click();
	}
		
}

