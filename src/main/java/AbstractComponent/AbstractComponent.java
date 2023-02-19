package AbstractComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToFrame(WebElement frameid) {
		driver.switchTo().frame(frameid);
	}
}
