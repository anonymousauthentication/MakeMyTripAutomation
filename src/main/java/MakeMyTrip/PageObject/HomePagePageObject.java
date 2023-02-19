package MakeMyTrip.PageObject;

import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponent.AbstractComponent;

public class HomePagePageObject extends AbstractComponent {
	WebDriver driver;
	public HomePagePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li[data-cy*=\"roundTrip\"]")
	WebElement roundTrip;

	@FindBy(css = "iframe[id=\"webklipper-publisher-widget-container-notification-frame\"]")
	WebElement frameid;

	@FindBy(css = "input[id=\"fromCity\"]")
	WebElement fromCity;

	@FindBy(css = "li[class*=\"react-autosuggest__suggestion\"]")
	List<WebElement> citySuggestion;

	@FindBy(css = "input[id=\"toCity\"]")
	WebElement toCity;

	@FindBy(css = "div[class*=\"DayPicker-Day\"]")
	List<WebElement> dayPicker;

	@FindBy(css = "a[class=\"close\"]")
	WebElement closeAdd;

	@FindBy(css = "span[data-cy=\"handleSnackbarClose\"]")
	WebElement closePopup;

	@FindBy(xpath = "//a[text()=\"Search\"]")
	WebElement searchButton;

	public void fromAndtoCity(String from, String to) {
		//Select From and TO city
		if (frameid.isDisplayed()) {
			//Advertisement Frame close
			switchToFrame(frameid);
			closeAdd.click();
			driver.switchTo().defaultContent();
		}
		if (closePopup.isDisplayed()) {
			//Advertisement Frame close
			closePopup.click();
		}
		roundTrip.click();
		fromCity.sendKeys(from);
		for (int i = 0; i < citySuggestion.size(); i++) {
			if (citySuggestion.get(i).getText().contains(from)) {
				citySuggestion.get(i).click();
			}
		}
		toCity.sendKeys(to);
		for (int i = 0; i < citySuggestion.size(); i++) {
			if (citySuggestion.get(i).getText().toLowerCase().contains(to)) {
				System.out.println("d");
				citySuggestion.get(i).click();
			}
		}

	}
	
	public void searchTrip() {
		//Get available Flight for from and to city for selected date 
		departuredateSelect();
		ReturnDateSelect();
		searchButton.click();
		
	}

	@SuppressWarnings("deprecation")
	public void departuredateSelect() {
		//Select Departure Date (Current day)
		Date date = new Date();
		System.out.println(date);
		int currentDate = date.getDate();
		String cc = Integer.toString(currentDate);
		System.out.println(currentDate);
		for (int i = 0; i < dayPicker.size(); i++) {
			System.out.println(dayPicker.get(i).getText());
			if (dayPicker.get(i).getText().contains(cc)) {
				System.out.println("Inside current");
				dayPicker.get(i).click();
				break;
			}
		}
	}

	public void ReturnDateSelect() {
		//Select Return Date (7 Days After Current day)
		Date date = new Date();
		System.out.println(date);
		int currentDate = date.getDate();
		String cc = Integer.toString(currentDate + 7);
		System.out.println(currentDate);
		for (int i = 0; i < dayPicker.size(); i++) {
			System.out.println(dayPicker.get(i).getText());
			if (dayPicker.get(i).getText().contains(cc)) {
				System.out.println("Inside current");
				dayPicker.get(i).click();
				break;
			}
		}
	}
}
