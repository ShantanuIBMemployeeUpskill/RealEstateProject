package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_RealEstate_POM {

	private WebDriver driver;

	public HomePage_RealEstate_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//a[contains(@class,'sign-in')]")
	private WebElement Loginbutton;
	
	@FindBy(id="menu-item-570")
	private WebElement PlotItem;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='45']")
	private WebElement Option1;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='46']")
	private WebElement Option2;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='47']")
	private WebElement Option3;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='48']")
	private WebElement Option4;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='49']")
	private WebElement Option5;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-3-posts')]//a[contains(text(),'Donec quis')]")
	private WebElement Option6;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-3-posts')]//a[contains(text(),'Maecenas viverra')]")
	private WebElement Option7;
	
	@FindBy(xpath="//a[contains(text(),'Real Estate')]")
	private WebElement title;
	
	@FindBy(id="menu-item-354")
	private WebElement NewLaunchSection;
	
	@FindBy(id="menu-item-617")
	private WebElement BlogSection;
	
	
	public void clickLoginButton()
	{
		this.Loginbutton.click();
	}
	
	public void ValidateTextsOnHomePage()
	{
		Actions a3= new Actions(driver);
		a3.moveToElement(PlotItem).build().perform();
		String FirsttextOfTC= Option1.getText();
		String SecondtextOfTC= Option2.getText();
		String ThirdtextOfTC= Option3.getText();
		String FourthtextOfTC= Option4.getText();
		String FifthtextOfTC= Option5.getText();
		String SixthtextOfTC= Option6.getText();
		String SeventhtextOfTC= Option7.getText();
	}

	public void ValidatingPlotSection()
	{
		Option6.click();
		
	}
	public void AlwaysgotoHomePage()
	{
		title.click();
	}
	public void GotoNewLaunchPage()
	{
		NewLaunchSection.click();
	}
	public void GotoBlogPage()
	{
		BlogSection.click();
	}


}
