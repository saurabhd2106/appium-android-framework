package commonLibs.Implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.android.AndroidDriver;

public class TouchGestures {

	TouchActions touchAction;

	public TouchGestures(AndroidDriver<WebElement> driver) {

		touchAction = new TouchActions(driver);
	}

	public void singleTap(WebElement element) {
		touchAction.singleTap(element).perform();
	}

	public void doubleTap(WebElement element) {
		touchAction.doubleTap(element).perform();
	}

	public void moveToLocation(int xCordinate, int yCordinate) {
		touchAction.move(xCordinate, yCordinate).perform();
	}

	public void longPress(WebElement element) {

		touchAction.longPress(element).perform();
	}

	public void Scroll(WebElement element, int xOffset, int yOffset) {

		touchAction.scroll(element, xOffset, yOffset).perform();
	}

}
