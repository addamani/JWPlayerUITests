package com.jwplayer.app.UITests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.jwplayer.app.utils.AppiumTestDriver;

public class ADSPage extends AppiumTestDriver{
	
	@iOSFindBy(name="Pre-Roll Only")
	static MobileElement PreRollOnlyButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]")
	static MobileElement PlayButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
	static List<MobileElement> ADPlayButton;
	
	static List<MobileElement> LoadADText;
	
	@iOSFindBy(name="01:40")
	static List<MobileElement> VideoTimer;
	
	//Function to click on Pre-Roll Button
	static void clickPreRollOnlyButton() throws InterruptedException
	{
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Clicking on pre-roll only button");
			PreRollOnlyButton.click();
			PageFactory.initElements(new AppiumFieldDecorator(driver),new ADSPage());
		} 	
		catch (Exception e) {
			throw new IllegalArgumentException("Could not click on pre-roll label");
		}

	}
	
	//Function to click on play button
	static void clickPlayButton() throws InterruptedException
	{
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Clicking on pre-roll only button");
			//driver.findElementsByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]");
			PlayButton.click();
			PageFactory.initElements(new AppiumFieldDecorator(driver),new ADSPage());
		} 	
		catch (Exception e) {
			throw new IllegalArgumentException("Could not click on current location label");
		}

	}
	
	//Funtion to verify text "Loading ad"
	static Boolean loadADText() throws InterruptedException
	{
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Clicking on play Button");
			LoadADText = driver.findElementsByName("Loading ad");
			if(LoadADText.size() > 0)
				return true;
			else
				return false;
		}	
		catch (Exception e) {
			throw new IllegalArgumentException("Unable to find label");
		}

	}
	
	//Funtion to click on ad play player button
	static void clickADPlayButton() throws InterruptedException
	{
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Clicking on play Button");
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]").click();
		}
		
		catch (Exception e) {
			throw new IllegalArgumentException("Could not click on play button");
		}

	}
	
	//Function to verify video timer value
	static Boolean videoTimerText() throws InterruptedException
	{
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Clicking on play Button");
			if(VideoTimer.size() > 0)
				return true;
			else
				return false;
		}	
		catch (Exception e) {
			throw new IllegalArgumentException("Could not find timer");
		}

	}
	

}
