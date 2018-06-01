package com.ipdect;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ipdect.DriverFactory.BrowserType;



public class Browser {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
//	static WebDriver driver =  new RemoteWebDriver ( new URL("http://localhost:4444/wd/hub"), 
//			new DesiredCapabilities("firefox", "",Platform.WINDOWS));
	
//	
	public static void setupDriver(String driverType) {
		if(driver!=null) {
			return;
		}else {
			DriverFactory.BrowserType type = BrowserType.valueOf(driverType);
			Browser.driver = DriverFactory.getDriver(type);
		}
	}
	
	

	
	public static void goTo(String url) {	
		
			driver.get(url);	
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	}

	public static boolean navBarItemName(String string) {	
		
		List<WebElement> navBarMenu = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']//li"));		
		boolean result = false;		

		for (WebElement element: navBarMenu) {
			String classsState = element.getAttribute("class");
			String innerTextValue = element.getAttribute("textContent");			
			boolean resultTemp = classsState.equals("active") && innerTextValue.equals(string);
			
			if (resultTemp) {
				systemOutMessage( innerTextValue + " page is accessible");				
				result = true;
			}else {
			if(findMe(string, innerTextValue)) {
				systemOutMessage( innerTextValue + " page isn't accessible");	
			}
			}
		}
		
		return result;
	}
	
	
	//getTitle from WebElement
	public static String getTitlefromWebelement() {
		return  driver.getTitle();
	}
	
	//Find WebElement 
	public static WebElement findElementOnPage(String string, int i) {
		return driver.findElement(selectLocator(string, i));
	}

	//getInnerHTML from WebElement
	public static String getInnerHTML(WebElement webElement) {		 		
		return webElement.getAttribute("innerHTML");
	}
	
	//getText from WebElement
	public static String getTextFromElement(WebElement webElement) {		 		
		return webElement.getText();
	}
	
	public static boolean checkStringsEquals(String string1, String string2) {		 		
		return string1.equals(string2);
	}
		
	
	public static String replaceAllSpaces(String string) {
		return string.replaceAll("\\s","");
	}
	
	
    public static boolean findMe(String subString, String mainString) {
        boolean foundme = false;
        int max = mainString.length() - subString.length();
 
 
        // Implement your own Contains Method with Recursion
        checkrecusion: for (int i = 0; i <= max; i++) {
            int n = subString.length();
 
            int j = i;
            int k = 0;
 
            while (n-- != 0) {
                if (mainString.charAt(j++) != subString.charAt(k++)) {
                    continue checkrecusion;
                }
            }
            foundme = true;
            break checkrecusion;
        }
//        System.out
//        .println(foundme ? "\nImplement your own Contains() Method - Result: Yes, Match Found.."
//                : "\nImplement your own Contains() Method - Result:  Nope - No Match Found..");
        return foundme;
    }
	
	public static void systemOutMessage (String string) {
		System.out.println("\n" + string);	
	}
	public static void resultOutput (boolean result, String positief, String negatif) {
		if (result) {
			Browser.systemOutMessage(positief);
		}else {
			Browser.systemOutMessage(negatif);
		}
	}	

//	RightClick on FirstTableRow
	public static void rightClickItem(String string) {
		waitElementVisible(string,1);
		rightClick(findElementOnPage(string, 1));	
	}
	
	public static void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).contextClick().build().perform();	
	}
	
	public static void clickButton(String string) {
		waitElementVisible(string,2);
		findElementOnPage(string, 2).click();		
	}
	
	public static List<WebElement> findListElementsOnPage(By by){
		List<WebElement> listElements = driver.findElements(by);
		return listElements;		
	}
	
	
	


	public static void selectMultipleElement( ) {		
	
		
		WebElement option1 = findElementOnPage("subscription-row-5000", 1);
//		waitElementVisible(subscription-row-5000, i);
		
		WebElement option2 = findElementOnPage("subscription-row-5001", 1);
		WebElement option3 = findElementOnPage("subscription-row-5002", 1);
		WebElement option4 = findElementOnPage("subscription-row-5003", 1);

		
		Actions action = new Actions(driver);
		            action.click(option1).keyDown(Keys.CONTROL).click(option2).keyDown(Keys.CONTROL)
		            .click(option3).keyDown(Keys.CONTROL).click(option4).keyUp(Keys.CONTROL).build().perform();
	}
	
		
	
	public static void waitElementVisible(String string, int i) {
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(selectLocator(string, i)));
	}
	
	
	
	
	public static By selectLocator(String string, int i) {
		By by = null;
		
		if (i==1) {
			by = By.id(string);
		}
		else if (i==2) {
			by = By.xpath(string);
		}
		else if (i==3) {
			by = By.cssSelector(string);
		}
		
		return by;
		
	}
//.//*[@id='contextmenu-subscriptions-button-enable-subscription']
	
	
	
	public static void close() {
		driver.close();
	}







}
