package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.GenericMethods;

public class AddNewPostPage_POM {

private WebDriver driver;

private GenericMethods gm;
	

	public AddNewPostPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	@FindBy(id="title")
	private WebElement titleInAddNewPost;
	
	@FindBy(id="content")
	private WebElement contentInAddNewPost;
	
	@FindBy(xpath="//ul[@id='categorychecklist']//li//label[contains(text(),'New Launches')]")
	private WebElement selectCategoryInAddNewPost;
	
	@FindBy(xpath="//div[@id='publishing-action']//input[@id='publish']")
	private WebElement publishButtonInAddNewPost;
	
	@FindBy(xpath="//a[contains(text(),'View post')]")
	private WebElement viewingNewpostInBlog;
	
	public void AddingNewPost() throws InterruptedException
	{
		titleInAddNewPost.sendKeys("Posting new Text");
		contentInAddNewPost.sendKeys("New Project is launched");
		selectCategoryInAddNewPost.click();
		publishButtonInAddNewPost.submit();
		WebDriverWait w= new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		publishButtonInAddNewPost.click();
		viewingNewpostInBlog.click();
	}
	public void AddNewPostWithoutCategorySelection()
	{
		titleInAddNewPost.sendKeys("New Launches");
		contentInAddNewPost.sendKeys("New Launch in Home");
		publishButtonInAddNewPost.submit();
		WebDriverWait w= new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		publishButtonInAddNewPost.click();
	}

}
