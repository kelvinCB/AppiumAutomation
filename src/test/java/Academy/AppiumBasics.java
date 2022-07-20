package Academy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasics {
	
	@Test
	public void appiumTest() throws IOException {
		AndroidDriver driver = Mobile.initializeApp();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();;
	}

}
