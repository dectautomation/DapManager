package com.ipdect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public enum BrowserType {
		FIREFOX,
		CHROME,
		IE,
		SAFARI,
	}
	
	public static WebDriver getDriver (BrowserType type) {
		
		WebDriver driver = null;
		
		switch (type) {
			case FIREFOX:
//				System.setProperty("webdriver.gecko.driver", "C:/dev/tools/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				driver = new FirefoxDriver();
		}
			
		return driver;
	}

}