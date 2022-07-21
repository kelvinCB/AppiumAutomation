package Academy;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class ObjectConstants {
	

	/***********************/
	/** API DEMOS / HOME  **/
	/***********************/
	
	public static final By PREFERENCE					= AppiumBy.accessibilityId("Preference");
	public static final By TEXT							= AppiumBy.accessibilityId("Text");
	public static final By VIEWS						= AppiumBy.accessibilityId("Views");
	
	/*****************************/
	/** API DEMOS / PREFERENCE  **/
	/*****************************/
	
	public static final By PREFERENCE_DEPENDENCIES		= AppiumBy.accessibilityId("3. Preference dependencies");
	
	
	/******************************/
	/** API DEMOS / PREFERENCE D **/
	/******************************/
	
	public static final By WIFI_CHECKBOX				= AppiumBy.id("android:id/checkbox");
	public static final By WIFI_SETTINGS_LABEL			= AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']");
	public static final By WIFI_SETTINGS_INPUT			= AppiumBy.id("android:id/edit");
	
	public static final By OK							= AppiumBy.xpath("//android.widget.Button[@text='OK']");
	
}
