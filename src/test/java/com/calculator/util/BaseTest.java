package com.calculator.util;


import java.net.URL;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.android.calculator.tests.Calculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseTest {
	
    public static Properties properties = PropertyLoader.getInstance().getProperties();
    public static Logger logger = Logger.getLogger(BaseTest.class.getName());  
    public static AndroidDriver androidDriver;
    
    String app_package = properties.getProperty("APP_PACKAGE");
    String app_activity = properties.getProperty("APP_ACTIVITY");
    
    //Create a complete URL base on default.properties
    String completeURL = "http://" +properties.getProperty("APPIUM_SERVER_IP") + ":" + properties.getProperty("APPIUM_PORT") + "/wd/hub";
    
    @BeforeTest (alwaysRun=true)
	public void setUp() throws Exception {
		logger.info("Initialize devices");
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Anddroid Emulator");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, app_package);
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, app_activity);
		
		androidDriver=new AndroidDriver(new URL(completeURL), capabilities);
		
	}
    
    @AfterTest
	public void tearDown() throws Exception{
    	androidDriver.quit();
	}
    
}