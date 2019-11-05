package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_POM {

	private WebDriver driver;

	public LoginPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//h2[contains(text(),'My Profile')]")
	private WebElement PageTitle;
	
	@FindBy(id="user_login")
	private WebElement userID;
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginButton;
	
	public void validateTitle()
	{
		String AssertPageTitle1= this.PageTitle.getText();
		assertEquals(AssertPageTitle1,"My Profile");
	}
	public void EnterUsername(String userID)
	{
		this.userID.clear();
		this.userID.sendKeys(userID);
	}
	
	public void EnterPassword(String password)
	{
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickSignInButton()
	{
		this.loginButton.click();
	}
}