package com.mmt.tests;

import org.testng.annotations.Test;

public class MMTHomepageTests extends BaseTest{
	
	
	String url = "https://makemytrip.com";
	
	@Test
	public void verifyApplicationLaunch() throws Exception{
		
		//cmnDriver.navigateToUrl(url);
		
		System.out.println(cmnDriver.getCurrentActivity());
		
		System.out.println(cmnDriver.getCurrentPackage());
		Thread.sleep(5000);
		
		
	}

}
