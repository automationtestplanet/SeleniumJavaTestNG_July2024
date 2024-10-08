package org.openms.demo.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	private WebElement userNameElement;

	@FindBy(id = "password")
	private WebElement passwordElement;

	@FindBy(css = "input[value='Log In']")
	private WebElement loginButtonElement;

	public WebElement getUserNameElement() {
		return userNameElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}

	public WebElement getLoginButtonElement() {
		return loginButtonElement;
	}

	public void setUserName(String userName) {
		getUserNameElement().sendKeys(userName);
	}

	public void setPassword(String password) {
		getPasswordElement().sendKeys(password);
	}

	public void clickModule(String moduleName) {
		driver.findElement(By.id(moduleName)).click();
	}

	public void clickLoginButton() {
		getLoginButtonElement().click();
	}

	public void loginToOpenMrs(String userName, String password, String moduleName) {
//		driver.findElement(By.id("username")).sendKeys(userName);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.id(moduleName)).click();
//		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.alert('Please click ok to Continue.............')");
			Thread.sleep(5000);
			
//			Alert alert = driver.switchTo().alert();
//			alert.accept(); // alert.dismiss();
			driver.switchTo().alert().accept();
			setUserName(userName);
			setPassword(password);
			clickModule(moduleName);
			clickLoginButton();
		} catch (Exception e) {
			System.out.println("Exception Occured while login to application: "+ e.getMessage());
		}
	}

	public boolean verifyLoginPage() {
		return driver.getTitle().trim().equalsIgnoreCase("Login");
	}
}
