package MakeMyTrip.Test;

import java.io.IOException;

import org.testng.annotations.Test;

import common.BaseTest;

public class LaunchWeb extends BaseTest {
	@Test(groups="openmakeMyTrip")
	public void openurl() throws IOException {
		invokeBrowser();
	}
}
