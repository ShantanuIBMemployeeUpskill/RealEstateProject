package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.HomePage_RealEstate_POM;
import com.training.pom.NewLaunchPage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FourthTestCase {


	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private HomePage_RealEstate_POM HP3;
	private NewLaunchPage_POM NL1;

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
	public void testCase4() throws InterruptedException
	{
		HP3= new HomePage_RealEstate_POM(driver);
		NL1= new NewLaunchPage_POM(driver);
		HP3.GotoNewLaunchPage();
		NL1.addAndSearchProperty();
		HP3.AlwaysgotoHomePage();
	}

}
