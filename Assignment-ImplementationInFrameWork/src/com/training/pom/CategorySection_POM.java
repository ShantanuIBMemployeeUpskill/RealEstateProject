package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategorySection_POM {
	
private WebDriver driver;
	

	public CategorySection_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(id="tag-name")
	private WebElement NameInCategory;
	
	@FindBy(id="tag-slug")
	private WebElement SlugInCategory;
	
	@FindBy(id="tag-description")
	private WebElement DescriptionInCategory;
	
	@FindBy(id="submit")
	private WebElement SubmitInCategory;
	
	@FindBy(xpath="//tbody[@id='the-list']//tr//td//strong//a[contains(text(),'New Launches')]")
	private WebElement verifyCategoryEntry;
	
	public void enterDetailsInCategorySection()
	{
		NameInCategory.sendKeys("New Launches");
		SlugInCategory.sendKeys("Launch");
		DescriptionInCategory.sendKeys("New Launches of villas, apartments, flats");
		SubmitInCategory.click();
		driver.navigate().refresh();
	}
	public void verifyEnteredCategoryDetails()
	{
		assertEquals(verifyCategoryEntry.getText(), "New Launches");
	}
}
