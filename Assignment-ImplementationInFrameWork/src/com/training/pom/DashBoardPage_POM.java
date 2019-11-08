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
	
	@FindBy(xpath="//div[contains(text(),'Comments')]")
	private WebElement CommentSection;
	
	@FindBy(id="wp-admin-bar-my-account")
	private WebElement ProfileNavigateOptions;
	
	@FindBy(xpath="//li[contains(@id,'wp-admin-bar-logout')]//a[contains(text(),'Log Out')]")
	private WebElement LogOutButton;
	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement PostSectionOfDashboard;
	
	@FindBy(xpath="//a[contains(text(),'All Post')]")
	private WebElement allPostsPostSection;
	
	@FindBy(xpath="//a[contains(text(),'Add New')]")
	private WebElement addNewPostInPostSection;
	
	@FindBy(xpath="//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Categories')]")
	private WebElement CategorySectionInPostSection;
	
	@FindBy(xpath="//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Tags')]")
	private WebElement TagSectionInPostSection;
	
	@FindBy(xpath="//li[@class='wp-first-item current']")
	private WebElement AllPostsSectionWithinPosts;
	
	@FindBy(xpath="//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-property']")
	private WebElement PropertySection;
	
	@FindBy(xpath="//a[contains(text(),'All Properties')]")
	private WebElement AllPropertySection;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement AddNewInPropertySection;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	private WebElement FeaturesInPropertySection;
	
	@FindBy(xpath="//a[contains(text(),'Regions')]")
	private WebElement RegionInPropertySection;
	
	@FindBy(xpath="//a[contains(text(),'Properties Settings')]")
	private WebElement SettingsInPropertySection;
	
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
	
	public void navigateToPostSection()
	{
		Actions a4= new Actions(driver);
		a4.moveToElement(PostSectionOfDashboard).build().perform();
		assertEquals(allPostsPostSection.getText(), "All Posts");
		assertEquals(addNewPostInPostSection.getText(), "Add New");
		assertEquals(CategorySectionInPostSection.getText(), "Categories");
		assertEquals(TagSectionInPostSection.getText(), "Tags");		
	}
	
	public void navigateInsideCategorySection()
	{
		CategorySectionInPostSection.click();
		
	}
	
	public void navigateToAllPostSection()
	{
		PostSectionOfDashboard.click();
		AllPostsSectionWithinPosts.click();
	}

	public void checkComments()
	{
		CommentSection.click();	
	}
	public void navigateToAddNew()
	{
		addNewPostInPostSection.click();
	}
	public void navigateToPropertySection()
	{
		Actions a5= new Actions(driver);
		a5.moveToElement(PropertySection).build().perform();
		assertEquals(AllPropertySection.getText(), "All Properties");
		assertEquals(AddNewInPropertySection.getText(), "Add New");
		assertEquals(FeaturesInPropertySection.getText(), "Features");
		assertEquals(RegionInPropertySection.getText(), "Regions");
		assertEquals(SettingsInPropertySection.getText(), "Properties Settings");
		AddNewInPropertySection.click();
	}
}
