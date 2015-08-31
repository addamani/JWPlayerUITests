package com.jwplayer.app.UITests;

import static org.junit.Assert.*;
import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jwplayer.app.utils.InitializeDriver;


public class JWPlayerTests extends InitializeDriver{
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
		driver.resetApp();
	}
	
	@Test
	public void testBuyMarketrateDeal() throws InterruptedException, IOException {
		System.out.println("Running test Buy Marketrate deal end to end");
		JWPlayerHomePage.clickADSButton(); //Click on ads button
		ADSPage.clickPreRollOnlyButton(); //Click on pre-roll button
		ADSPage.clickPlayButton();//Click on ad play 
		ADSPage.clickADPlayButton();//Click on player to pause the app
		driver.wait(2000);
		assertTrue(ADSPage.loadADText());//Verify text "Loading ad" . This will verify if ad is playing or not
		ADSPage.clickADPlayButton();//Click on player to play the app
		driver.wait(10000);
		assertTrue(ADSPage.videoTimerText());//Verify timer of video. This will verify if video is playing or not
	}
	
	@Test
	public void testBuyBookingDeal() throws InterruptedException, IOException {
		int xCoordinates=109,yCoordinates=153;
		System.out.println("Running test Buy Marketrate deal end to end");
		JWPlayerHomePage.clickADSButton();
		ADSPage.clickPreRollOnlyButton();
		ADSPage.clickPlayButton();
		TouchAction ta = new TouchAction(driver);
		driver.performTouchAction(ta.longPress(xCoordinates,yCoordinates, 10000));//Click on player click to launch url
		driver.wait(10000);
		assertTrue(JWPayerURLPage.verifyURL());//verify jwplayer.com url
		driver.runAppInBackground(10);//relaunch app after few seconds
		assertTrue(ADSPage.loadADText());//verify if ad is paused or not
		
	}
	
	public void WaitForElementToDisplay()
	{
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}

}

	
