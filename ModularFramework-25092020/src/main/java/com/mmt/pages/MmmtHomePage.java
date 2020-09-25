package com.mmt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MmmtHomePage extends BasePage {
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hotels']//parent::android.widget.RelativeLayout")
	WebElement hotelButton;
	
	@CacheLookup
	@AndroidFindBy(uiAutomator  = "resourceId(\"com.makemytrip:id/city\")")
	WebElement cityTextview;

	public MmmtHomePage(AndroidDriver<WebElement> driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

	public void searchHotel() {

		touchControl.tap(hotelButton);
		
		elementControl.clickElement(cityTextview);

	}

}
