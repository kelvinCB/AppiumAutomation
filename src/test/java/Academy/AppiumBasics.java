package Academy;

import java.io.IOException;

import org.testng.Assert;
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
		Mobile.closeApp();
		Mobile.stopService();
		Util.soundBeep();
	}

	@Test
	public void longPressureGesture() throws IOException {
		AndroidDriver driver = Mobile.initializeApp();
		Mobile.tap(ObjectConstants.VIEWS);
		Mobile.tap(ObjectConstants.EXPANDABLE_LISTS);
		Mobile.tap(ObjectConstants.CUSTOM_ADAPTER);
		Mobile.longTapGesture(ObjectConstants.PEOPLE_NAMES, 2);
		Mobile.delay(2);
		Assert.assertTrue(Mobile.verifyElementPresent(ObjectConstants.SAMPLE_MENU));		
		Mobile.closeApp();
		Mobile.stopService();
		Util.soundBeep();
	}
	
	
	@Test
	public void longPressureGesture2() throws IOException {
		AndroidDriver driver = Mobile.initializeApp();
		Mobile.tap(ObjectConstants.VIEWS);
		Mobile.tap(ObjectConstants.EXPANDABLE_LISTS);
		Mobile.tap(ObjectConstants.CUSTOM_ADAPTER);
		Mobile.longTapGesture(100,100,2);
		Mobile.delay(2);
		Mobile.closeApp();
		Mobile.stopService();
		Util.soundBeep();
	}
	
}
