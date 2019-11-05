package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Blog_POM {

private WebDriver driver;
	

	public Blog_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 

@FindBy(xpath="//a[@class='button fullwidth margin-top-20']")
private WebElement problemSolverButton;

	public void GotoContactForm()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",problemSolverButton);
	}

}
