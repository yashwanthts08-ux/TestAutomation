package pages;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	 WebDriverWait wait;
	@FindBy(xpath="//input[@name='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='pass']")
	private WebElement password;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	


public void setUsername(String name) {
	wait.until(ExpectedConditions.visibilityOf(username));
	username.sendKeys(name);
}

public void setPassword(String pass) {
	password.sendKeys(pass);
}
public String title() {
	
	return driver.getTitle();


}}
