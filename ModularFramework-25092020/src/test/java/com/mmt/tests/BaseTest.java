package com.mmt.tests;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.mmt.pages.MmmtHomePage;

import commonLibs.Implementation.CommonDriver;
import commonLibs.Implementation.CommonKeys;
import commonLibs.Implementation.DeviceSettings;
import commonLibs.utils.ConfigFileUtils;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	CommonDriver cmnDriver;
	
	String currentWorkingDirectory;
	String configFile;
	Properties configProperties;
	
	MmmtHomePage homepage;
	
	CommonKeys cmnKeys;
	
	public AndroidDriver<WebElement> driver;
	
	@BeforeSuite
	public void preSetup() throws Exception{
		
		currentWorkingDirectory = System.getProperty("user.dir");
		
		configFile = currentWorkingDirectory + "/config/config.properties";
		configProperties = ConfigFileUtils.readConfigFile(configFile);
	}
	
	@BeforeClass
	public void setup() throws Exception{
		
		DeviceSettings deviceSettings = new DeviceSettings();
		
		deviceSettings.setBrowserType(configProperties.getProperty("BROWSER_TYPE"));
		deviceSettings.setPlatformName(configProperties.getProperty("PLATFORM_NAME"));
		deviceSettings.setPlatformVersion(configProperties.getProperty("PLATFORM_VERSION"));
		deviceSettings.setDeviceName(configProperties.getProperty("DEVICE_NAME"));
		deviceSettings.setUdid(configProperties.getProperty("UDID"));
		deviceSettings.setApp(configProperties.getProperty("APP"));
		
		cmnDriver = new CommonDriver(deviceSettings);
		
		driver = cmnDriver.getDriver();
		cmnKeys = new CommonKeys(driver);
		homepage = new MmmtHomePage(driver);
	}
	
	@AfterClass
	public void ceanUp() {
		cmnDriver.quitApp();
	}

}
