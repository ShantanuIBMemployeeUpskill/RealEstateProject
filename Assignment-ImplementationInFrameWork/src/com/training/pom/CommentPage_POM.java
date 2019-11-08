package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
	public class CommentPage_POM{

		private WebDriver driver;

		public CommentPage_POM(WebDriver driver) {
			PageFactory.initElements(driver, this);
		} 
		
	@FindBy(xpath="//table//tbody//tr[1]//td[2]//p[contains(text(),'Comment is entered')]")
	private WebElement RecentComment;
	
	public void verifyComments()
	{
		assertEquals(RecentComment.getText(), "Comment is entered");
	}
}
