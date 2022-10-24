package utils;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {
	
	public WebDriver driver;
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Custom sendKeys method/ Wraps selenium default SendKeys and enhace it
	 * with clear() method before sending the text.
	 * @param locator --> used inside method to create an WebElement object
	 * @param value --> String value
	 */
	public void sendKeys(By locator, String value) {
		WebElement element =  driver.findElement(locator);
		waitForElementToBeVisible(element);
		try {
			Log.info("Called <sendKeys> " + element.getAttribute("outerHTML"));
			element.clear();
			Log.info("Called <sendKeys> " + element.getAttribute("outerHTML"));
			element.sendKeys(value);
			
		}catch(Exception e) {
			
			Log.error("Element not found in method <waitForElementToBeVisible>");
			Log.error(e.getMessage());
		}
		
	}
	/**
	 * 
	 * @param element
	 */
	public void click(By locator) {
		WebElement element =  driver.findElement(locator);
		Log.info("Called method <click> " + element.getAttribute("outerHTML"));
		try {
			waitForElementToBeClickable(element);
			element.click();
			
		}catch(NoSuchElementException e) {
			
			Log.error("Element not found in method <click> after 10seconds");
			Log.error(e.getMessage());
			
		}catch (StaleElementReferenceException e) {
			
			WebElement element2 =  driver.findElement(locator);
			Log.info("Called method <StaleElementReferenceException> " + element2.getAttribute("outerHTML"));
			element2.click();
		}
		
	}
	/**
	 * 
	 * @param element
	 */
	public void waitForElementToBeClickable(WebElement element) {
		try {
			Log.info("Called <waitForElementToBeClickable> " + element.getAttribute("outerHTML"));
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch(NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeClickable> after 10seconds");
			Log.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param element
	 */
	public void waitForElementToBeVisible(WebElement element) {
		try {
			Log.info("Called <waitForElementToBeVisible> " + element.getAttribute("outerHTML"));
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		} catch(NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeVisible> after 10seconds");
			Log.error(e.getMessage());
		}
	}
	
	public void dragAndDrop(By locator, int x, int y) {
		
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.dragAndDropBy(element,x, y).perform();
		
		//action.clickAndHold(element).moveByOffset(300, 0).release().build().perform();
		//action.sendKeys(Keys.TAB).click().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		//action.moveByOffset(600, 300);
		//action.click();
		
		
	}
	

}