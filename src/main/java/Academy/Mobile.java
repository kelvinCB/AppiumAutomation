package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class Mobile {

	private static AndroidDriver driver;

	public static AndroidDriver initializeApp() throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("files/properties/GlobalVariables.properties");
		prop.load(fis);
		
		//Start Appium Server Automatically
		AppiumDriverLocalService serviceBuilder = new AppiumServiceBuilder().usingAnyFreePort().build();
		serviceBuilder.start();
		
		//Configure Automation Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("deviceName"));
		options.setApp(prop.getProperty("app"));
		
		//Start Android Driver with Capabilites configured
		driver = new AndroidDriver(options);
		
		return driver;
	

	}
	
}
