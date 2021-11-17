package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects {
	WebDriver driver=null;	
	By username= By.xpath("//input[@name='username']");
	By password= By.xpath("//input[@name='password']");
	By loginBtn= By.xpath("//button[@class='btn btn-login-bg btn-user btn-block']");
	
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	public void enterUserName(String text) {
		driver.findElement(username).sendKeys(text);
	}
	public void enterPassword(String text) {
		driver.findElement(password).sendKeys(text);
	}
	public void clickSubmitBtn() {
		driver.findElement(loginBtn).click();
	}
}
