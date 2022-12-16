package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginObjects {
	
	WebDriver driver;
	public loginObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='inputUsername']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(css="button[type='submit']") WebElement loginBtn;
	@FindBy(css=".logout-btn") WebElement logoutBtn;
	
	
	public void setUserName(String user) {
		username.clear();
		username.sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void BtnClick() {
		loginBtn.click();
	}
	
	public void logoutClick() {
		logoutBtn.click();
	}


}
