package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class BlogPage  extends SeleniumWrappers{
	
public WebDriver driver;
	
	public BlogPage(WebDriver driver) {
		super(driver);
		
	}

	public By Name = By.xpath("//input[@id='author']"); 
	public By Email = By.xpath("//input[@id='email']");
	public By Comment = By.xpath("//textarea[@id='comment']");
	public By Post = By.xpath("//input[@name='submit' and @id='send_comment']");
	public By Response = By.xpath("//div[@class='comment_not_approved']");
	public By anyBlog = By.xpath("//a[contains(text(), '10 Book Recommendations')]");
	public By gallery = By.xpath("//a[contains(text(), 'Gallery Format')]");

	
	public void postComment(String name, String email, String comment) {
		//driver.findElement(anyBlog).click();
		driver.findElement(Comment).sendKeys(comment);
		driver.findElement(Name).sendKeys(name);
		driver.findElement(Email).sendKeys(email);
		driver.findElement(Post).click();
	}
	
}