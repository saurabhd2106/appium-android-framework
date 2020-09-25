package commonLibs.Implementation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class ElementControl {
	
	
	public void clickElement(WebElement element) {
		element.click();
		
	}

	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getTagName(WebElement element) {
		return element.getTagName();
	}

	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelectable(WebElement element) {
		return element.isSelected();
	}

	public Dimension getSize(WebElement element) {
		return element.getSize();
	}

	public String getCssProperty(WebElement element) {
		return element.getCssValue("style");
	}

	public int getXLocation(WebElement element) {
		return element.getLocation().x;
	}

	public int getYLocation(WebElement element) {
		return element.getLocation().y;
	}
}
