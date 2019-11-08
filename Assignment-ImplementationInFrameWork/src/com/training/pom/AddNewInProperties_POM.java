package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.GenericMethods;

public class AddNewInProperties_POM {

	private WebDriver driver;

		public AddNewInProperties_POM(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}

		@FindBy(id="title")
		private WebElement TitleTextBox;
		
		@FindBy(id="content")
		private WebElement ContentTextBox;
		
		@FindBy(xpath="//div[@id='publishing-action']//input[@id='publish']")
		private WebElement publishButtonInPropertyPage;
		
		@FindBy(xpath="//a[contains(text(),'View post')]")
		private WebElement ViewPostButtonInProperty;
		
		public void addNewProperty()
		{
			TitleTextBox.sendKeys("new launch");
			ContentTextBox.sendKeys("new launch");
			publishButtonInPropertyPage.submit();
			WebDriverWait w= new WebDriverWait(driver, 30);
			w.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			publishButtonInPropertyPage.click();
			
		}
		public void viewPropertyPost()
		{
			ViewPostButtonInProperty.click();
}
}