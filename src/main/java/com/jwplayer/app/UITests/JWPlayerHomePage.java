package com.jwplayer.app.UITests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.jwplayer.app.utils.AppiumTestDriver;

public class JWPlayerHomePage extends AppiumTestDriver{
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	static MobileElement SkinsButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	static MobileElement CaptionsButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")
	static MobileElement AdsButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")
	static MobileElement StreamsButton;
	
	
	//Function to click ADS Button
	static void clickADSButton() throws InterruptedException
	{
		try {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Clicking on Getaways tab");
		AdsButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new ADSPage());
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Could not click on ADS Button");
		}
		

	}
}
