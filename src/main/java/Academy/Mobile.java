package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Mobile {

	private static AndroidDriver driver;
	private static AppiumDriverLocalService serviceBuilder;

	public static AndroidDriver initializeApp() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("files/properties/GlobalVariables.properties");
		prop.load(fis);

		// Start Appium Server Automatically
		serviceBuilder = new AppiumServiceBuilder().usingAnyFreePort().build();
		serviceBuilder.start();

		// Configure Automation Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("deviceName"));
		options.setApp(prop.getProperty("app"));

		// Start Android Driver with Capabilites configured
		driver = new AndroidDriver(options);
		implicitWait(5);		
		return driver;

	}

	public static void tap(By object) {
		driver.findElement(object).click();
		System.out.println("Element: " + object + " tapped");
	}

	public static void setText(By object, String text) {
		driver.findElement(object).sendKeys(text);
		System.out.println("Text: " + text + " was written on Element: " + object);
	}

	public static String getText(By object) {
		System.out.println("Obtained Text: " + driver.findElement(object).getText());
		return driver.findElement(object).getText();
	}

	public static void doubleClick(By object) {
		tap(object);
		tap(object);
	}

	public static void longTapGesture(By object, int seconds) {
	   ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) driver.findElement(object)).getId(),
						"duration", (seconds*1000)));
	}

	public static void longTapGesture(int xPosition, int yPosition, int seconds) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("x", xPosition, "y", yPosition, "duration", (seconds*1000)));
	}

	public static void tapAndHold(By object) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(object)).clickAndHold().build().perform();
	}

	public static void clear(By object) {
		driver.findElement(object).clear();
	}

	public static void closeApp() {
		driver.quit();
		System.out.println("App was closed!");
	}

	public static void stopService() {
		serviceBuilder.stop();
		System.out.println("Appium Service was stopped!");
	}

	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		System.out.println("Implicit Wait is: " + seconds + " seconds.");
	}

	public static void delay(int seconds) {

		try {
			System.out.println("Delay: " + seconds + " seconds");
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void takeScreenShot(String fileWithPath) {

		// Convert driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Screenshot taken");

	}

	public static void takeScreenShot(By object, String fileWithPath) {

		// Get element to screenshot
		WebElement element = driver.findElement(object);

		// Call getScreenshotAs method to create image file
		File SrcFile = element.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Screenshot taken");

	}

	public static String getAttribute(By object, String attribute) {
		return driver.findElement(object).getAttribute(attribute);
	}

	public static void check(By object) {
		if (driver.findElement(object).isSelected())
			System.out.println(object + " Already checked.");
		else {
			driver.findElement(object).click();
			System.out.println(object + " Checked.");
		}

	}

	public static void uncheck(By object) {
		if (driver.findElement(object).isSelected()) {
			driver.findElement(object).click();
			System.out.println(object + " Unchecked.");
		} else
			System.out.println(object + " Already Unchecked.");
	}
	
	public static boolean verifyElementPresent(By object) {
		if (driver.findElement(object).isDisplayed())
			System.out.println("True " + object + " is present.");
		else
			System.out.println("False " + object + " is Not present.");
		return driver.findElement(object).isDisplayed();
	}
	
	
	
}
