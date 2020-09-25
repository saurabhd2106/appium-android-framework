package com.mmt.tests;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.mmt.pages.MmmtHomePage;

import commonLibs.Implementation.CommonDriver;
import commonLibs.Implementation.CommonKeys;
import commonLibs.Implementation.DeviceSettings;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	CommonDriver cmnDriver;

	String executionStartTime;
	String currentWorkingDirectory;
	String configFile;
	Properties configProperties;

	MmmtHomePage homepage;

	CommonKeys cmnKeys;

	public AndroidDriver<WebElement> driver;

	private String reportFilename;
	public ReportUtils reportUtils;

	public ScreenshotUtils screenshotControl;

	@BeforeSuite
	public void preSetup() throws Exception {

		executionStartTime = DateUtils.getCurrentDateAndTime();

		currentWorkingDirectory = System.getProperty("user.dir");

		configFile = currentWorkingDirectory + "/config/config.properties";
		configProperties = ConfigFileUtils.readConfigFile(configFile);

		reportFilename = String.format("%s/reports/mmtReport-%s.html", currentWorkingDirectory, executionStartTime);

		reportUtils = new ReportUtils(reportFilename);
	}

	@BeforeClass
	public void setup() throws Exception {

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

		screenshotControl = new ScreenshotUtils(driver);
	}

	@AfterMethod
	public void postTestActions(ITestResult result) throws Exception {

		String testcaseName = result.getName();
		String currentTime = DateUtils.getCurrentDateAndTime();

		String imageFilename = String.format("%s/screenshots/%s-%s.jpeg", currentWorkingDirectory, testcaseName,
				currentTime);
		if (result.getStatus() == ITestResult.FAILURE) {
			reportUtils.addLogs(Status.FAIL, "One or more steps failed..");

			screenshotControl.captureAndSaveScreenshot(imageFilename);

			reportUtils.addScreenshotInReport(imageFilename);
		}
	}

	@AfterClass
	public void ceanUp() {
		cmnDriver.quitApp();
	}

	@AfterSuite
	public void postCleanup() {
		reportUtils.flushReport();
	}

}
