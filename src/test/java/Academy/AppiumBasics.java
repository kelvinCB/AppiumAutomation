package Academy;

import java.io.IOException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppiumBasics {
	
	@Test
	public void wifiSettingsName() throws IOException {
		AndroidDriver driver = Mobile.initializeApp();
		Mobile.tap(ObjectConstants.PREFERENCE);
		Mobile.tap(ObjectConstants.PREFERENCE_DEPENDENCIES);
		Mobile.uncheck(ObjectConstants.WIFI_CHECKBOX);
		Mobile.check(ObjectConstants.WIFI_CHECKBOX);
		Mobile.tap(ObjectConstants.WIFI_SETTINGS_LABEL);
		Mobile.setText(ObjectConstants.WIFI_SETTINGS_INPUT, "KLK WAWAWA");
		Mobile.tap(ObjectConstants.OK);
	}

}
