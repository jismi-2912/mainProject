package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void javascriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectDropdownWithIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
	}

	public void mouseRightClickAction(WebElement rightClick) {
		Actions actions = new Actions(driver);
		actions.contextClick(rightClick).build().perform();
	}

	public void mouseHoverAction(WebElement mouseHover) {

		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHover).build().perform();
	}

	public void keyboardAction() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}

	public void handlingCheckbox(WebElement checkbox) {

		checkbox.click();
	}

	public void hadlingMultipleCheckboxes(WebElement checkBox) {

		List<WebElement> checkBox1 = driver.findElements(By.xpath("checkBox"));

		Iterator<WebElement> iterator = checkBox1.iterator();
		while (iterator.hasNext()) {
			WebElement checkbox = iterator.next();
			checkbox.click();
		}
	}

	public void handlingRadioButton(WebElement checkbox) {

		checkbox.click();
	}

}
