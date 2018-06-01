package com.ipdect;

public class AccessPointsNavBar {
	
	static String url = "http://localhost/cds/radios";
	
	static String navBarName = "Access Points";
	
	public void goTo() {
		Browser.goTo(url);
    }

	public boolean isAt() {
		return Browser.navBarItemName(navBarName);
	}



}
