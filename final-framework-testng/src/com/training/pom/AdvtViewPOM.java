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

public class AdvtViewPOM {
	private WebDriver driver; 
	
	public AdvtViewPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//input[contains(@linkurl,'memberAds')]")
	private WebElement mngadvt;
	
	@FindBy(id="newButton")
	private WebElement insnewadvt;
	
	@FindBy(name="ad(title)")
	private WebElement title;
	
	@FindBy(name="ad(category)")
	private WebElement category;
	
	@FindBy(name="ad(price)")
	private WebElement price;
	
	@FindBy(id="notExpirableCheck")
	private WebElement ntexpirable;
	
	//@FindBy(id="cke_contents_descriptionText")
	//@FindBy(tagName="iframe")
	@FindBy(xpath="//td[@id='cke_contents_descriptionText']//iframe")
	private WebElement description;
	
	//@FindBy(xpath="//input[@id='saveButton']")
	//private WebElement savebtn;
	
	@FindBy(xpath="//*[@id=\"menu15\"]/span[2]")
	private WebElement logout;
	
	@FindBy(xpath="//*[@id=\"menu1\"]/span[2]")
	private WebElement personal;
	
	@FindBy(xpath="//*[@id=\"submenu1.2\"]/span[2]")
	private WebElement advts;
	
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
	
	public void clickmngadvt() {
		this.mngadvt.click(); 
	}
	
	public void insnewadvt() {
		this.insnewadvt.click(); 
	}
	
	public void sendtitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	public void selcategory() {
		  Select sel = new Select(category); 
		  sel.selectByVisibleText("Example ad category");
	}
	
	public void sendprice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void chkntexpirable() {
		this.ntexpirable.click(); 
	}
	
	public void senddescrip() throws InterruptedException  {
		//driver.switchTo().frame("440e02a05a2353da7a6cbbdcaeea0e4c");
		WebDriver frame= driver.switchTo().frame(description);
		Thread.sleep(3000);
		WebElement el=driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		driver.findElement(By.xpath("/html/body")).sendKeys("data about advt");
		//driver.switchTo().frame(description);
		//driver.findElement(By.xpath("//title[contains(@data-cke-title,'Rich text editor, descriptionText')]")).sendKeys("new offer availabe");;
		//this.descrip.click();
		//this.descrip.sendKeys(descrip);
		driver.switchTo().defaultContent();
	}
	
	public void clicksavebtn() {

		JavascriptExecutor js= (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,500)");
			
			WebElement ele=driver.findElement(By.id("saveButton"));
			js.executeScript("arguments[0].scrollIntoView();",ele);
			ele.click();	
	}

	public void clickOK() {
		Alert al=driver.switchTo().alert();
		al.accept();
		//al.dismiss();	
	}
	
	public void logoutfunc() {
	     this.logout.click();
	}
	
	public void clickok() {
		Alert al=driver.switchTo().alert();
		al.accept();
		//al.dismiss();	
	}
	
	public void personaltab() {
		this.personal.click();
	}
	
	public void clickadvts() {
		this.advts.click();
	}
	
}
