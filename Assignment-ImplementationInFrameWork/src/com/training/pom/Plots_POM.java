package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Plots_POM {

	private WebDriver driver;
	

	public Plots_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")
	private WebElement nameElement;
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-text']")
	private WebElement Subject;
	
	@FindBy(xpath="//textarea[@class='wpcf7-form-control wpcf7-textarea']")
	private WebElement textarea;
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement button;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement message;
	
	@FindBy(id="amount")
	private WebElement MortgageCalculatorAmount;
	
	@FindBy(id="downpayment")
	private WebElement MortgageCalculatorDownpayment;
	
	@FindBy(id="years")
	private WebElement MortgageCalculatorTime;
	
	@FindBy(id="interest")
	private WebElement MortgageCalculatorInterest;
	
	@FindBy(xpath="//button[contains(text(),'Calculate')]")
	private WebElement clickButton;
	
	@FindBy(xpath="//div[contains(text(),'Monthly')]")
	private WebElement message1;
	
	@FindBy(xpath="//strong[@class='calc-output']")
	private WebElement message2;
	
	public void sendValues()
	{
		nameElement.sendKeys("reva");
		email.sendKeys("revasharma@gmail.com");
		Subject.sendKeys("apartments");
		textarea.sendKeys("looking for an apartments");
		button.click();
		message.getText();	
	}
	public void sendValuesToMortgageCalculator()
	{
		MortgageCalculatorAmount.sendKeys("400000");
		MortgageCalculatorDownpayment.sendKeys("20000");
		MortgageCalculatorTime.sendKeys("20");
		MortgageCalculatorInterest.sendKeys("7.25");
		clickButton.click();
		String one= message1.getText();
		String two= message2.getText();
		System.out.println(one.concat(two));
	}
	

}
