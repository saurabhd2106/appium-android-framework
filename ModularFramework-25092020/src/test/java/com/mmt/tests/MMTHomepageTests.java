package com.mmt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MMTHomepageTests extends BaseTest {

	String url = "https://makemytrip.com";

	@Test
	public void verifyApplicationLaunch() throws Exception {

		// cmnDriver.navigateToUrl(url);

		System.out.println(cmnDriver.getCurrentActivity());

		System.out.println(cmnDriver.getCurrentPackage());
		

		homepage.searchHotel();
		
		Thread.sleep(5000);
		
		String expectedActivityId = "com.mmt.travel.app.home.ui.SplashActivity";
		String actualActivityId = cmnDriver.getCurrentActivity();
		
		Assert.assertEquals(actualActivityId, expectedActivityId);

	}

}
