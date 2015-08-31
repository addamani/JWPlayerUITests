package com.jwplayer.app.UITests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.jwplayer.app.utils.AppiumTestDriver;

public class JWPayerURLPage extends AppiumTestDriver{
	
	
	@iOSFindBy(accessibility="jwplayer.com")
	static List<MobileElement> ConfirmURL;
	
	
	//Function to verify jwplayer url 
	static Boolean verifyURL() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Boolean isurlPresent = false;
		if (ConfirmURL.size() > 0) {
			isurlPresent = true;				
		}
		return isurlPresent;
	}
}
