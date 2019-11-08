package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllPosts_POM {

private WebDriver driver;
	

	public AllPosts_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement AddNewPost;
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped posts']//tbody//tr[1]//td[1]//strong//a[contains(text(),'New Launches')]")
	private WebElement RecentPost;
	
	public void AddNewPostButton()
	{
		AddNewPost.click();
	}

	public void validateRecentPost()
	{
		assertEquals(RecentPost.getText(),"New Launches");	
		RecentPost.click();
	}
}
