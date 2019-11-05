package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_POM {

	
private WebDriver driver;
	

	public Contact_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//input[@placeholder='Your Name']")
	private WebElement nameInContactForm;
	
	@FindBy(xpath="//input[@placeholder='Email Address']")
	private WebElement emailIDinContactForm;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	private WebElement subjectInContactForm;
	
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement messageInForm;
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement SendButtonClick;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement messageFinal;

	public void fillFormInContactPage()
	{
		nameInContactForm.sendKeys("reva");
		emailIDinContactForm.sendKeys("revasharma@gmail.com");
		subjectInContactForm.sendKeys("apartment");
		messageInForm.sendKeys("looking for apartments");
		SendButtonClick.click();
		String Message= messageFinal.getText();
	}
}
