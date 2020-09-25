package commonLibs.Implementation;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TouchGestureAppium {
	AndroidDriver<WebElement> driver;

	public TouchGestureAppium(AndroidDriver<WebElement> driver) {

		this.driver = driver;
	}

	public void tap(WebElement element) {
		TouchAction touchAction = new TouchAction<>(driver);
		
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
	}

	public void longPress(WebElement element) {
		TouchAction touchAction = new TouchAction(driver);

		touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))
				.withDuration(Duration.ofSeconds(2))).release().perform();
	}
	

}
