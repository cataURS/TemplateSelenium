package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JSExecutorExample extends BaseTest{
	
	@Test
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://www.emag.ro/'")  ;//Object...arga
		
		driver.navigate().back();
		jse.executeScript("window.history.go(-1)");
	}

}
