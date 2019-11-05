package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage_POM {

	private WebDriver driver;
	

	public DashBoardPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	private WebElement DashBoardTitle;
	
	@FindBy(id="wp-admin-bar-my-account")
	private WebElement ProfileNavigateOptions;
	
	@FindBy(xpath="//li[contains(@id,'wp-admin-bar-logout')]//a[contains(text(),'Log Out')]")
	private WebElement LogOutButton;
	
	public void validatePageTitleDashboardPage()
	{
		String AssertTitle2= this.DashBoardTitle.getText();
		assertEquals(AssertTitle2, "Dashboard");
	}
	
	public void navigateToProfileOption()
	{	
		Actions a2= new Actions(driver);
		a2.moveToElement(ProfileNavigateOptions).build().perform();	
	}		
	
	public void navigateToLogOutOption()
	{
		Actions a3= new Actions(driver);
		a3.moveToElement(LogOutButton).click().build().perform();
	}
}
