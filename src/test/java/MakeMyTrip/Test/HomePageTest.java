package MakeMyTrip.Test;

import org.testng.annotations.Test;
import MakeMyTrip.PageObject.HomePagePageObject;
import MakeMyTrip.TestComponent.Retry;
import common.BaseTest;

public class HomePageTest extends BaseTest {
	@Test(dependsOnGroups = "openmakeMyTrip", retryAnalyzer = Retry.class)
	public void homepageTest() {
		HomePagePageObject homepage = new HomePagePageObject(BaseTest.driver);
		homepage.fromAndtoCity("delhi", "bengaluru");
		homepage.searchTrip();
	}
}
