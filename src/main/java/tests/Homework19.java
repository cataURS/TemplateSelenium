package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.BlogPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class Homework19 extends BaseTest{

	@Test
	public void postFormat() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NavMenuPage menu =  new NavMenuPage(driver);
		BlogPage blog = new BlogPage(driver);
		
		String javaScriptHover = "var objObject = document.createEvent('MouseEvents');" +
								 "objObject.initMouseEvent('mouseover',true);" +
								 "arguments[0].dispatchEvent(objObject);";
		jse.executeScript(javaScriptHover, menu.getElement(menu.blog));
		jse.executeScript("arguments[0].click()", menu.getElement(menu.postFormats));
		jse.executeScript("arguments[0].scrollIntoView()", blog.getElement(blog.gallery));
		jse.executeScript("arguments[0].click()", blog.getElement(blog.gallery));
		//jse.executeScript("arguments[0].scrollIntoView().click().sendKeys('Just a comment')", blog.getElement(blog.Comment));
		//am vrut sa fac asta dar nu-mi iese exact chainingul asta
		
		jse.executeScript("arguments[0].scrollIntoView({block: 'center'})", blog.getElement(blog.Comment));
		jse.executeScript("arguments[0].click()", blog.getElement(blog.Comment));
		jse.executeScript("arguments[0].value='Just a comment4'", blog.getElement(blog.Comment));
		jse.executeScript("arguments[0].value='User Name4'", blog.getElement(blog.Name));
		jse.executeScript("arguments[0].value='user4@email.co'", blog.getElement(blog.Email));
		jse.executeScript("arguments[0].click()", blog.getElement(blog.Post));
		Thread.sleep(2000);
		//am adaugat si o validare
		jse.executeScript("arguments[0]", blog.validate(blog.Response));
		
	}
}