package com.ipdect;

public class AdminNavBar {
	
	static String url = "http://localhost/cds/admin";
	
	static String driverType = "FIREFOX";
	
	static String navBarName = "Admin";
	
	static String addNumberRangeXpath = ".//*[@id='button-subscriptions-add-range']";
	
	static String numberRangeFromXpath = "contextmenu-subscriptions-from";
	
	static String numberRangeToXpath = "contextmenu-subscriptions-to";
	
	static String addNumberOkButtonXpath = ".//*[@id='contextmenu-subscriptions-addrange-ok']";
	
	static String numberFrom = "5000";
	
	static String numberTo = "5003";
	
	static String numberRangeAddedMessage = "html/body/div[2]/div/div[1]/div[2]/p";
	
	public void goTo() {
		Browser.goTo(url);
	}
	
	public void driverSetUp() {
		Browser.setupDriver(driverType);		
	}

	public boolean isAt() {
	    return Browser.navBarItemName(navBarName);
	}
	
	public boolean addNumberRange() {
		boolean result = true;
		Browser.clickButton(addNumberRangeXpath);
		Browser.findElementOnPage(numberRangeFromXpath, 1).sendKeys(numberFrom);;
		Browser.findElementOnPage(numberRangeToXpath, 1).sendKeys(numberTo);;
		Browser.findElementOnPage(addNumberOkButtonXpath, 2).click();
		Browser.waitElementVisible(numberRangeAddedMessage, 2);
		String string = Browser.findElementOnPage(numberRangeAddedMessage, 2).getText();
		
		if (string=="Number range successfully added") {
			Browser.systemOutMessage("mesaj ayniymis");
			result = true;
		}else {
			result = false;
		}
		
		return result;
	}



}
