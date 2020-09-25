package com.mmt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class MMTHomepageTests extends BaseTest {

	String url = "https://makemytrip.com";

	@Test
	public void verifyApplicationLaunch() throws Exception {
		
		reportUtils.createATestcase("Verify Application Launch");

		// cmnDriver.navigateToUrl(url);
		
		reportUtils.addLogs(Status.INFO, "Current activity id is - "+ cmnDriver.getCurrentActivity());
		System.out.println(cmnDriver.getCurrentActivity());

		reportUtils.addLogs(Status.INFO, "Current package id is - "+ cmnDriver.getCurrentPackage());
		System.out.println(cmnDriver.getCurrentPackage());
		

		homepage.searchHotel();
		
		Thread.sleep(5000);
		
		String expectedActivityId = "com.mmt.travel.app.home.ui.SplashActivity";
		String actualActivityId = cmnDriver.getCurrentActivity();
		
		Assert.assertEquals(actualActivityId, expectedActivityId);
		
		reportUtils.addLogs(Status.INFO, "Test complete successfully");

	}

}
