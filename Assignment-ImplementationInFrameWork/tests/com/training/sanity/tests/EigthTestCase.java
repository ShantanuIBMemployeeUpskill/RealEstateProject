package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AddNewPostPage_POM;
import com.training.pom.AllPosts_POM;
import com.training.pom.Blog_POM;
import com.training.pom.CategorySection_POM;
import com.training.pom.CommentPage_POM;
import com.training.pom.DashBoardPage_POM;
import com.training.pom.HomePage_RealEstate_POM;
import com.training.pom.LoginPage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EigthTestCase {

	private WebDriver driver;
	private String baseUrl;
	private HomePage_RealEstate_POM HP5;
	private LoginPage_POM loginPage1;
	private DashBoardPage_POM HoverAndAction1;
	private CategorySection_POM category;
	private AllPosts_POM allpost;
	private AddNewPostPage_POM addnewPost;
	private Blog_POM blog1;
	private CommentPage_POM comment;
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
	public void testCase8()
	{
		HP5= new HomePage_RealEstate_POM(driver);
		HP5.GotoBlogPage();
		blog1= new Blog_POM(driver);
		blog1.ReadMoreSectionOfAddedPost();
		HP5.clickLoginButton();
		loginPage1= new LoginPage_POM(driver);
		loginPage1.EnterUsername("admin");
		loginPage1.EnterPassword("admin@123");
		loginPage1.clickSignInButton();
		HoverAndAction1= new DashBoardPage_POM(driver);
		HoverAndAction1.checkComments();
		comment= new CommentPage_POM(driver);
		comment.verifyComments();
	}
	
}
