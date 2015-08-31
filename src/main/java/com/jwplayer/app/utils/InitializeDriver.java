package com.jwplayer.app.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.jwplayer.app.UITests.JWPlayerHomePage;



public class InitializeDriver {

	public static AppiumDriver driver;
	public static String platform;

	@BeforeClass
	public static void createEnvironment() throws Exception{
		System.out.println("Into initialize driver");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,System.getProperty("PlatformName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,System.getProperty("PlatformVersion"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,System.getProperty("DeviceName"));
		capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("AppPath"));

		if (System.getProperty("PlatformName").compareTo("iOS") == 0) {
			System.out.println("Running @Test for IOS device ");
			platform = "iOS";
			driver=new IOSDriver(new URL("http://127.0.0.1:4890/wd/hub"),capabilities);
			Thread.sleep(4000);
			
		} else {
			System.out.println("Running @Test for Android device ");
			platform = "Android";
			driver = new AndroidDriver(new URL("http://127.0.0.1:4890/wd/hub"),
					capabilities);
			Thread.sleep(4000);

		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		PageFactory.initElements(new AppiumFieldDecorator(driver), new JWPlayerHomePage());

	}
	
	@AfterClass
	public static void  tearEnvironment()
	{
		driver.quit();	
	}
	
}
