package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPage_POM {

private WebDriver driver;
	

	public NewLaunchPage_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(id="keyword_search")
	private WebElement addressBox;
	
	@FindBy(xpath="//div[@id='_property_type_chosen']//a//div")
	private WebElement propertyType;
	
	@FindBy(xpath="//ul[@class='chosen-results']//li[@data-option-array-index='3']")
	private WebElement ChosenProperty;
		
	@FindBy(xpath="//div[@class='chosen-container chosen-container-single']//a[@class='chosen-single chosen-default']//div")
	private WebElement anyRegion;
	
	@FindBy(xpath="//div[@class='chosen-drop']//ul//li[@data-option-array-index='6']")
	private WebElement ChosenRegion;
	
	@FindBy(xpath="//div[@class='col-md-12']//button[contains(text(),'Search')]")
	private WebElement SearchButton;
	
	
	public void addAndSearchProperty() throws InterruptedException
	{
		addressBox.sendKeys("Electronic City"+Keys.RETURN);
		propertyType.click();
		ChosenProperty.click();
		anyRegion.click();
		ChosenRegion.click();
		SearchButton.click();
		/*JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",SearchButton);	*/
		Thread.sleep(4000);
	}
}

