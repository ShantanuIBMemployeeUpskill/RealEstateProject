package com.Upskill.ibm;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases_WEEK1 {

	public WebDriver d;
	
	//<----------------Initializing and Starting the Browser------------->
	
	@BeforeTest
	
	public void InitializingBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ShantanuTandon\\Desktop\\Selenium IDE Training samples\\chromedriver_win32\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		d.get("http://realestatem1.upskills.in/");
		d.manage().window().maximize();				
	}
	//<----------------Starting Validations TestCase 1------------->
	@Test
	public void testCase1() throws InterruptedException
	{
		d.findElement(By.xpath("//a[contains(@class,'sign-in')]")).click();
		String PageTitleAssertion1= d.findElement(By.xpath("//h2[contains(text(),'My Profile')]")).getText(); 
		assertEquals(PageTitleAssertion1,"My Profile");
		System.out.println("Login Screen Displayed");
		d.findElement(By.id("user_login")).sendKeys("admin");
		d.findElement(By.id("user_pass")).sendKeys("admin@123");
		d.findElement(By.name("login")).click();
		System.out.println("User is able to Click on Login Button");
		String PageTitleAssertion2= d.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		assertEquals(PageTitleAssertion2, "Dashboard");
		System.out.println("User lands on User Profile/DashBoard");
		Actions a1= new Actions(d);
		WebElement element1= d.findElement(By.id("wp-admin-bar-my-account"));
		WebElement element2= d.findElement(By.xpath("//li[@id='wp-admin-bar-logout']//a[contains(text(),'Log Out')]"));
		a1.moveToElement(element1).moveToElement(element2).click().build().perform();	 
		assertEquals(PageTitleAssertion1,"My Profile");	
		CloseProcessAndBrowser();
	}
	
	//<----------------Starting Validations TestCase 2------------->
	@Test
	public void testCase2()
	{
		InitializingBrowser();
		Actions a2= new Actions(d);
		WebElement element8= d.findElement(By.id("menu-item-570"));
		a2.moveToElement(element8).build().perform();
		WebElement element3=d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='45']"));
		String Option1_Villa_Megamenu= element3.getText();
		WebElement element4= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='46']"));
		String Option2_Villa_Megamenu= element4.getText();
		WebElement element5= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='47']"));
		String Option3_Villa_Megamenu= element5.getText();
		WebElement element6= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='48']"));
		String Option4_Villa_Megamenu= element6.getText();
		WebElement element7= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='49']"));
		String Option5_Villa_Megamenu= element7.getText();
		WebElement element9= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-3-posts')]//a[contains(text(),'Donec quis')]"));
		String Option1_DescriptionMenu= element9.getText();
		WebElement element10= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-3-posts')]//a[contains(text(),'Maecenas viverra')]"));
		String Option2_DescriptionMenu= element10.getText();
		element9.click();
		d.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")).sendKeys("reva");
		d.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")).sendKeys("revasharma@gmail.com");
		d.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-text']")).sendKeys("apartments");
		d.findElement(By.xpath("//textarea[@class='wpcf7-form-control wpcf7-textarea']")).sendKeys("looking for an apartments");
		d.findElement(By.xpath("//input[@value='Send']")).click();
		String Output3= d.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		System.out.println(Output3);
		if(Output3.equals("Thank you for your message. It has been sent."))
		{
			System.out.println("TestCase Pass");
		}
		else
		{
			System.out.println("Test Case failed");
		}
		CloseProcessAndBrowser();
	}
	
	//<----------------Starting Validations TestCase 3------------->
	@Test
	public void testCase3()
	{
		InitializingBrowser();
		Actions a2= new Actions(d);
		WebElement element8= d.findElement(By.id("menu-item-570"));
		a2.moveToElement(element8).build().perform();
		WebElement element3=d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='45']"));
		String Option1_Villa_Megamenu= element3.getText();
		WebElement element4= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='46']"));
		String Option2_Villa_Megamenu= element4.getText();
		WebElement element5= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='47']"));
		String Option3_Villa_Megamenu= element5.getText();
		WebElement element6= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='48']"));
		String Option4_Villa_Megamenu= element6.getText();
		WebElement element7= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[1]//a[@data-new_object_id='49']"));
		String Option5_Villa_Megamenu= element7.getText();
		WebElement element9= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-3-posts')]//a[contains(text(),'Donec quis')]"));
		String Option1_DescriptionMenu= element9.getText();
		WebElement element10= d.findElement(By.xpath("//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-3-posts')]//a[contains(text(),'Maecenas viverra')]"));
		String Option2_DescriptionMenu= element10.getText();
		element9.click();
		String VerifyOverviewDonecQuies= d.findElement(By.xpath("//h3[contains(text(),'Donec quis - Overview ')]")).getText();
		String VerifyDetailsDonecQuies= d.findElement(By.xpath("//h3[contains(text(),'Donec quis - Details')]")).getText();
		d.findElement(By.id("amount")).sendKeys("400000");
		d.findElement(By.id("downpayment")).sendKeys("20000");
		d.findElement(By.id("years")).sendKeys("20");
		d.findElement(By.id("interest")).sendKeys("7.25");
		d.findElement(By.xpath("//button[contains(text(),'Calculate')]")).click();
		String Output1= d.findElement(By.xpath("//div[contains(text(),'Monthly')]")).getText();	
		String Output2= d.findElement(By.xpath("//strong[@class='calc-output']")).getText();
		System.out.println(Output1 + "is"+ Output2);
		CloseProcessAndBrowser();
	}
	
	@Test
	public void testCase4() throws InterruptedException
	{
		InitializingBrowser();
		d.findElement(By.id("menu-item-354")).click();
		d.findElement(By.id("keyword_search")).sendKeys("Electronic City"+Keys.RETURN);
		System.out.println("Text entered");
		WebElement element11= d.findElement(By.xpath("//div[@id='_property_type_chosen']//a//div"));
		element11.click();
		System.out.println("Element clicked");
		d.findElement(By.xpath("//ul[@class='chosen-results']//li[@data-option-array-index='3']")).click();
		WebElement element12= d.findElement(By.xpath("//div[@class='chosen-container chosen-container-single']//a[@class='chosen-single chosen-default']//div"));
		element12.click();
		System.out.println("Element clicked");
		d.findElement(By.xpath("//div[@class='chosen-drop']//ul//li[@data-option-array-index='6']")).click();
		WebElement element13= d.findElement(By.xpath("//button[@class='button fullwidth']"));
		JavascriptExecutor js= (JavascriptExecutor) d;
		js.executeScript("arguments[0].click()",element13);
		Thread.sleep(4000);
		}
	
	@Test
	public void testCase5()
	{
		InitializingBrowser();
		d.findElement(By.id("menu-item-617")).click();
		WebElement DropButton= d.findElement(By.xpath("//a[@class='button fullwidth margin-top-20']"));
		JavascriptExecutor js= (JavascriptExecutor) d;
		js.executeScript("arguments[0].click()",DropButton);
		d.findElement(By.xpath("//input[@placeholder='Your Name']")).sendKeys("reva");
		d.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("revasharma@gmail.com");
		d.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("apartment");
		d.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("looking for apartments");
		d.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-submit']")).click();
		String OutputText= d.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		System.out.println(OutputText);
	}
	
	
	@AfterTest
	public void CloseProcessAndBrowser()
	{
	d.close();
	d.quit();
	}
	
}
