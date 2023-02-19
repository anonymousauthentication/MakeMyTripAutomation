package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	public String web_url;
	public Properties prop;
	public FileInputStream files;
	public static WebDriver driver;

	public void initBrowser() throws IOException {
		getGlobalData();
		web_url = prop.getProperty("Web_URL");
		System.out.println(web_url);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void invokeBrowser() throws IOException {
		initBrowser();
		goTomakeMyTrip();
	}

	public void goTomakeMyTrip() {
		System.out.println(web_url);
		driver.get(web_url);
	}

	public void getGlobalData() throws IOException {
		prop = new Properties();
		files = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/GlobalData.properties");
		prop.load(files);
	}

}
