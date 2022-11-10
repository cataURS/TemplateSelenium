package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import utils.SeleniumWrappers;

public class HomePage extends SeleniumWrappers{

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public By book1 = By.cssSelector("a[href='the-forest']");
	public By book2 = By.cssSelector("a[href='the-son']");
	public By book3 = By.cssSelector("a[href='life-in-the-garden']");
	public By book4 = By.cssSelector("a[href='the-long-road-to-the-deep-silence']");
	public By book5 = By.cssSelector("a[href='its-a-really-strange-story']");
	public By book6 = By.cssSelector("a[href='storm']");
	public By facebook = By.cssSelector("div[class='top_panel_top_socials'] a[href*='facebook']");
	public By twitter = By.cssSelector("div[class='top_panel_top_socials'] a[href*='twitter']");
	public By insta = By.cssSelector("div[class='top_panel_top_socials'] a[href*='instagram']");
	
	public boolean navigateValidate(By book, String url) {
		driver.findElement(book).click();
		String currentURL = driver.getCurrentUrl();
		assertEquals(currentURL, url);
		return true;
	}
  
	
	
	
	
	
}
