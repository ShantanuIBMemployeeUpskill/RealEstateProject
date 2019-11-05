package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DashBoardPage_POM;
import com.training.pom.HomePage_RealEstate_POM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FirstTestCase {

	private WebDriver driver;
	private String baseUrl;
	private HomePage_RealEstate_POM HP;
	private LoginPage_POM loginPage;
	private DashBoardPage_POM HoverAndAction;
	private static Properties properties;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}	

	@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
	}
	@Test
	public void testCase1() throws InterruptedException
	{
		HP= new HomePage_RealEstate_POM(driver);
		HP.clickLoginButton();
		loginPage= new LoginPage_POM(driver);
		loginPage.validateTitle();
		loginPage.EnterUsername("admin");
		loginPage.EnterPassword("admin@123");
		loginPage.clickSignInButton();
		HoverAndAction= new DashBoardPage_POM(driver);
		HoverAndAction.validatePageTitleDashboardPage();
		HoverAndAction.navigateToProfileOption();	
		HoverAndAction.navigateToLogOutOption();
}
}