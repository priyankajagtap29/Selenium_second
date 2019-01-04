package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewPaymentPOM {
	private WebDriver driver; 
	
	public ViewPaymentPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//input[contains(@linkurl,'payment?to=12')]")
	private WebElement paysysbtn;
	
	@FindBy(id="amount")
	private WebElement amt;
	
	@FindBy(name="type")
	private WebElement transaction;
	
	@FindBy(id="description")
	private WebElement textdescr;
	
	@FindBy(id="submitButton")
	private WebElement subbtn;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input")
	private WebElement finalsubmit;
	
	@FindBy(xpath="//*[@id=\"menu15\"]/span[2]")
	private WebElement logout;
	
	@FindBy(xpath="//*[@id=\"menu2\"]/span[2]")
	private WebElement account;
	
	@FindBy(xpath="//*[@id=\"submenu2.0\"]/span[2]")
	private WebElement accinfo;

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
	
	public void clickpaybtn() {
		this.paysysbtn.click(); 
	}
	
	public void sendamt(String amt) {
		this.amt.sendKeys(amt);
	}
	public void seltrans() {
		  Select sel = new Select(transaction); 
		  sel.selectByVisibleText("Debit to member");
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
	
	public void logoutfunc() {
	     this.logout.click();
	}
	
	public void clickok() {
		Alert al=driver.switchTo().alert();
		al.accept();
		//al.dismiss();	
	}
	
	public void accounttab() {
		this.account.click();
	}
	
	public void clickaccinfo() {
		this.accinfo.click();
	}
}

