package com.ipdect;

public class NavBar {
	
	public static SystemNavBar systemNavBar() {
		return new SystemNavBar();
	}

	public static SubscriptionsNavBar subscriptionsNavBar() {
		return new SubscriptionsNavBar();
	}

	public static AccessPointsNavBar accessPointsNavBar() {
		return new AccessPointsNavBar();
	}

	public static ProvisioningNavBar provisioningNavBar() {
		return new ProvisioningNavBar();
	}

	public static AdminNavBar adminNavBar() {
		return new AdminNavBar();
	}
}
