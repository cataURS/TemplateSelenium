package utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	//avem nevoie de asta doar pt rulare paralela
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver(getChromeOptions()));
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// set window size
			//driver.get().manage().window().setSize(new Dimension(800, 600));
			
			
			
			long chromeId = Thread.currentThread().getId();
			System.out.println("Chrome--> Thread id = " + chromeId);
			return driver.get();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			long firefoxId = Thread.currentThread().getId();
			System.out.println("Firefox--> Thread id = " + firefoxId);
			return driver.get();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			long edgeId = Thread.currentThread().getId();
			System.out.println("Edge--> Thread id = " + edgeId);
			return driver.get();
		}
		
		
		return driver.get();
	}
	
		public static ChromeOptions getChromeOptions() {
			ChromeOptions chromeOps = new ChromeOptions();
			chromeOps.addArguments("--disable-infobars");
			chromeOps.addArguments("--headless");
			chromeOps.addArguments("--windows-size=1500, 1280");
			return chromeOps;
			
		}

}
