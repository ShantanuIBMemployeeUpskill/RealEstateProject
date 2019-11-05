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
import com.training.pom.Plots_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ThirdTestCase {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private HomePage_RealEstate_POM HP2;
	private Plots_POM PM;
	
	
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
	public void testCase3()
	{
		HP2=new HomePage_RealEstate_POM(driver);
		HP2.ValidateTextsOnHomePage();
		HP2.ValidatingPlotSection();
		PM= new Plots_POM(driver);
		PM.sendValuesToMortgageCalculator();	
		HP2.AlwaysgotoHomePage();
	}
}
