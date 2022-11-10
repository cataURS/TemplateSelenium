package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EventsPage;
import pages.HomePage;
import pages.NavMenuPage;
import pages.SingleEventPage;
import utils.BaseTest;

public class Homework20 extends BaseTest{
	
	@Test
	public void SocialLinks() throws InterruptedException {
		
		NavMenuPage nav = new NavMenuPage(driver);
		nav.navigateTo(nav.facebook);
		Thread.sleep(3000);
		List<String> browserTabs =  new ArrayList<String>(driver.getWindowHandles());
		System.out.println(browserTabs.size());
		driver.switchTo().window(browserTabs.get(1));
		Assert.assertEquals(nav.readUrl(), "https://www.facebook.com/keytraining.ro" );
		System.out.println("Navigated successfully to FB");
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		
		nav.navigateTo(nav.twitter);
		Thread.sleep(3000);
		List<String> browserTabs1 =  new ArrayList<String>(driver.getWindowHandles());
		System.out.println(browserTabs1.size());
		driver.switchTo().window(browserTabs1.get(1));
		Assert.assertEquals(nav.readUrl(), "https://twitter.com/" );
		System.out.println("Navigated successfully to Twitter");
		driver.close();
		driver.switchTo().window(browserTabs1.get(0));

		System.out.println("Size :" + browserTabs1.size());
		
		Thread.sleep(3000);
		
		nav.navigateTo(nav.insta);
		Thread.sleep(3000);
		List<String> browserTabs11 =  new ArrayList<String>(driver.getWindowHandles());
		System.out.println(browserTabs11.size());
		driver.switchTo().window(browserTabs11.get(1));
		Assert.assertEquals(nav.readUrl(), "https://www.instagram.com/" );
		System.out.println("Navigated successfully to Instagram");
		driver.close();
		driver.switchTo().window(browserTabs11.get(0));

		System.out.println("Size :" + browserTabs11.size());
		
		Thread.sleep(3000);

	}
}
