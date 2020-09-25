package commonLibs.Implementation;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class CommonKeys {
	private AndroidDriver<WebElement> driver;
	private KeyEvent keyEvent;
	
	public CommonKeys(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	public void pressHomeKey() {
		keyEvent = new KeyEvent(AndroidKey.HOME);
		
		driver.longPressKey(keyEvent);
	}
	
	public void pressBackKey() {
		keyEvent = new KeyEvent(AndroidKey.BACK);
		
		driver.longPressKey(keyEvent);
	}
	
	public void pressAppSwitchKey() {
		keyEvent = new KeyEvent(AndroidKey.APP_SWITCH);
		
		driver.longPressKey(keyEvent);
	}

}
