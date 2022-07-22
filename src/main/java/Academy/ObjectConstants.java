package Academy;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class ObjectConstants {
	

	/***********/
	/** COMMONS  **/
	/***********/
	
	public static final By OK							= AppiumBy.xpath("//android.widget.Button[@text='OK']");
	public static final By UI_NOT_RESPONDING			= AppiumBy.xpath("//android.widget.TextView[@text='System UI isn't responding']");
	public static final By CLOSE_APP					= AppiumBy.xpath("//android.widget.Button[@text='Close app']");
	
	/***********/
	/** HOME  **/
	/***********/
	
	public static final By PREFERENCE					= AppiumBy.accessibilityId("Preference");
	public static final By TEXT							= AppiumBy.accessibilityId("Text");
	public static final By VIEWS						= AppiumBy.accessibilityId("Views");
	
	/*****************/
	/** PREFERENCE  **/
	/*****************/
	
	public static final By PREFERENCE_DEPENDENCIES		= AppiumBy.accessibilityId("3. Preference dependencies");
	public static final By WIFI_CHECKBOX				= AppiumBy.id("android:id/checkbox");
	public static final By WIFI_SETTINGS_LABEL			= AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']");
	public static final By WIFI_SETTINGS_INPUT			= AppiumBy.id("android:id/edit");
	
	/***********/
	/** VIEWS **/
	/***********/
	
	public static final By EXPANDABLE_LISTS				= AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]");
	public static final By CUSTOM_ADAPTER				= AppiumBy.accessibilityId("1. Custom Adapter");
	public static final By PEOPLE_NAMES					= AppiumBy.xpath("//android.widget.TextView[@text='People Names']");
	public static final By SAMPLE_MENU					= AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']");



}
