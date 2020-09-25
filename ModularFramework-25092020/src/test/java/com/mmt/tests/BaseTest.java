package com.mmt.tests;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import commonLibs.Implementation.CommonDriver;
import commonLibs.Implementation.DeviceSettings;
import commonLibs.utils.ConfigFileUtils;

public class BaseTest {
	
	CommonDriver cmnDriver;
	
	String currentWorkingDirectory;
	String configFile;
	Properties configProperties;
	
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
	}
	
	@AfterClass
	public void ceanUp() {
		cmnDriver.quitApp();
	}

}
