package com.ipdect;

import org.openqa.selenium.WebElement;

public class SystemNavBar {
	
	static String url = "http://localhost/cds";
	
	static String driverType = "FIREFOX"; //FIREFOX or CHROME driver
	
	static String dapManagerVersion = "DAP Manager INT  R6.6.2 Build 089";
	
	static String systemName = "My System10";
	
	static String navBarName = "System";
	
	static String tableSiteNamexPath = ".//*[@id='table-update-periods']/tbody/tr[1]/td[1]";
	
	static String dapManVersionNameElementXpath = "html/body/div[2]/div/div[1]/h3";
	
	//FIREFOX or CHROME driver
	public void driverSetUp() {
		Browser.setupDriver(driverType);		
	}
	
	public void goTo() {
		Browser.goTo(url);
	}
	

	public boolean isAt() {
		return Browser.navBarItemName(navBarName);
	}
	
	
	
	public boolean systemNameVerification() {
		WebElement element = Browser.findElementOnPage(tableSiteNamexPath,2);		
		String siteNameFromTable = Browser.getInnerHTML(element);		
		String titleOfTheNavBar = Browser.getTitlefromWebelement();
		boolean result = Browser.findMe(systemName,titleOfTheNavBar)&&Browser.checkStringsEquals(systemName,siteNameFromTable);		
		Browser.resultOutput(result,"System Name is verified","System Name isn't verified");
		return  result;		
	}
	
	public boolean DAPManVersionValidation() {

		WebElement element = Browser.findElementOnPage(dapManVersionNameElementXpath,2);		
		String dapManVersionName = Browser.getTextFromElement(element);	
		boolean result = Browser.findMe(dapManagerVersion,dapManVersionName);		
		Browser.resultOutput(result,"DAPMan Version is verified","DAPMan Version isn't verified");	
		return result;
		
	}




	

	

}
