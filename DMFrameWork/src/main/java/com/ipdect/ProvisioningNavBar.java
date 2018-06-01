package com.ipdect;

public class ProvisioningNavBar {
	
	static String url = "http://localhost/cds/provisioning";
	
	static String navBarName = "Provisioning";
	
	public void goTo() {
		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.navBarItemName(navBarName);
	}

}
