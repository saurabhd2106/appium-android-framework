package com.mmt.pages;

import org.openqa.selenium.WebElement;

import commonLibs.Implementation.ElementControl;
import commonLibs.Implementation.TouchGestureAppium;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	
	ElementControl elementControl;
	TouchGestureAppium touchControl;
	
	public BasePage(AndroidDriver<WebElement> driver) {
		elementControl = new ElementControl();
		touchControl= new TouchGestureAppium(driver);
	}

}
