package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Blog_POM {

private WebDriver driver;
public String enterComment;
	

	public Blog_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 

	Scanner sc= new Scanner(System.in);
	
	@FindBy(xpath="//a[contains(text(),'Real Estate')]")
	private WebElement GoingToHomePage;
	
	@FindBy(xpath="//a[@class='button fullwidth margin-top-20']")
	private WebElement problemSolverButton;

	@FindBy(xpath="//div[@class='col-md-12']//h2[contains(text(),'Blog')]")
	private WebElement PageName;

	@FindBy(xpath="//a[@class='read-more']")
	private WebElement RecentReadMoreElementAdded;

	@FindBy(id="comment")
	private WebElement CommentSection;

	@FindBy(id="submit")
	private WebElement SubmitButton;

	@FindBy(id="author")
	private WebElement nameInPost;

	@FindBy(id="email")
	private WebElement emailInPost;

	@FindBy(xpath="//div[@class='comment-content']//p[contains(text(),'Comment is entered')]")
	private WebElement verifyingComment;
	
	@FindBy(xpath="//div[@class='post-content']//p[contains(text(),'New Project is launched')]")
	private WebElement validTextInTextBoxInAddPost;

	public void getTitle()
	{
		String pageTileOfBlog= PageName.getText();
		if(pageTileOfBlog.equals("Blog"))
		{
			System.out.println("Test Case Passed");
		}
	}
	
	public void GotoContactForm()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",problemSolverButton);
	}
	
	public void verifyThePostEntered()
	{
		assertEquals(validTextInTextBoxInAddPost.getText(),"New Project is launched");
	}
	public void ReadMoreSectionOfAddedPost()
	{
		RecentReadMoreElementAdded.click();
		CommentSection.sendKeys("Comment is entered");
		nameInPost.sendKeys("Name");
		emailInPost.sendKeys("name@gmail.com");
		SubmitButton.click();
		/*String CommentActual= verifyingComment.getText();
		assertEquals(CommentActual, enterComment);*/
	}
	
	
}
