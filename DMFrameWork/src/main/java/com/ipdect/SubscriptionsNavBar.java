package com.ipdect;

public class SubscriptionsNavBar {
	
	static String enableButtonXpath = ".//*[@id='contextmenu-subscriptions-button-enable-subscription']";	
	static String deleteNumberButtonXpath =".//*[@id='contextmenu-subscriptions-button-delete-subscription']";

	static String url = "http://localhost/cds/subscriptions";
	
	static String navBarName = "Subscriptions";
	
	static String subscriptionTableID = "table-subscriptions";
	static String selectedDNR = "subscription-row-5000";	
	static String table = "table-subscriptions";	
	
	static String noAccessPointFoundMessage = "No operational Access Point present!";	
	static String noAccessPointFoundMessageXpath = "html/body/div[2]/div[1]/div[3]/p";
	
	static String subsNumberXpath = "/html/body/div[2]/div[1]/div[3]/ul/li[4]";
	static String registrationFailedXpath = "/html/body/div[2]/div[1]/div[3]/ul/li[7]";
	
	static String deleteNumberFrom = "5000";
	
	static String deleteNumberTo = "5003";

	
	
	static String driverType = "FIREFOX"; //FIREFOX or CHROME driver
	
	public void goTo() {		
		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.navBarItemName(navBarName);
	}
	
	public void driverSetUp() {
		Browser.setupDriver(driverType);		
	}

	public boolean enableButtonCheck() {	
		boolean result = false;
		Browser.rightClickItem(selectedDNR);
		Browser.clickButton(enableButtonXpath);
		
		if (Browser.findElementOnPage(noAccessPointFoundMessageXpath, 2).getText() != null) {
			Browser.systemOutMessage("Please add an Access Point to the System");
			result = true;

		}else if (Browser.findElementOnPage(subsNumberXpath, 2).getText() != null) {
			Browser.systemOutMessage("Number is subscribed");
			result = true;
		}else if (Browser.findElementOnPage(registrationFailedXpath, 2).getText() != null) {
			Browser.systemOutMessage("Registration failed, Please register handset within 3min");
			result = true;
		}
		
		return result;
		
	}

	public void deleteNumberRange() {
		Browser.selectMultipleElement();
		Browser.rightClickItem(selectedDNR);
		Browser.clickButton(deleteNumberButtonXpath);
		
	}

	public void checkButtons() {
	
		
	}

}
