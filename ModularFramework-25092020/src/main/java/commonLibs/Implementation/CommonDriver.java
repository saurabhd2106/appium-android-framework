package commonLibs.Implementation;

import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonDriver {

	private AndroidDriver<WebElement> driver;

	private int elementDetectionTimeout;

	private String currentWorkingDirectory;

	public AndroidDriver<WebElement> getDriver() {
		return driver;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public CommonDriver(DeviceSettings deviceSettings) throws Exception {
		elementDetectionTimeout = 10;

		currentWorkingDirectory = System.getProperty("user.dir");

		String browserType = deviceSettings.getBrowserType();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceSettings.getPlatformName());

		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceSettings.getPlatformVersion());

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceSettings.getDeviceName());

		capabilities.setCapability(MobileCapabilityType.UDID, deviceSettings.getUdid());

		if (browserType.equalsIgnoreCase("native")) {

			capabilities.setCapability(MobileCapabilityType.APP,
					currentWorkingDirectory + "/driver/" + deviceSettings.getApp());

			capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

			capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");

		} else if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.gecko.driver", "");

			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

		} else {
			throw new Exception("Invaid Browser Type - " + browserType);
		}

		URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(remoteUrl, capabilities);

	}

	public void navigateToUrl(String url) {

		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
	}

	public void quitApp() {
		driver.quit();
	}
	
	public void closeApp() {
		driver.close();
	}
	
	public void launchApp() {
		driver.launchApp();
	}
	
	public void runAppInBackground(int timeoutInseconds) {
		driver.runAppInBackground(Duration.ofSeconds(timeoutInseconds));
	}
	
	public void activateApp(String packageName) throws Exception {
		driver.activateApp(packageName);
	}

	public void terminateApp(String packageName) {
		driver.terminateApp(packageName);
	}

	public String getDeviceTime() throws Exception {
		return driver.getDeviceTime();

	}

	public double getBatteryInfo() throws Exception {
		AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();

		return batteryInfo.getLevel();
	}

	public String getCurrentActivity() {
		return driver.currentActivity();
	}

	public String getCurrentPackage() {
		return driver.getCurrentPackage();

	}

	public void getKeyboard() {
		driver.getKeyboard();
	}

	public void hideKeyboard() {
		if (driver.isKeyboardShown()) {
			driver.hideKeyboard();
		}
	}

	public void unlockDevice() {

		if (driver.isDeviceLocked()) {
			driver.unlockDevice();
		}
	}

	public void resetApp() {
		driver.resetApp();
	}

	public void rotateScreenToPortraitMode() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	public void rotateScreenToLandscapeMode() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}

	public String getContext() {
		return driver.getContext();
	}

	public Set<String> getAllContexts() {
		return driver.getContextHandles();
	}

	public void switchToNativeApp() {
		driver.context("NATIVE_APP");
	}

	public void switchToWebView() {
		Set<String> allContexts = getAllContexts();

		driver.context(allContexts.toArray()[1].toString());
	}

}
