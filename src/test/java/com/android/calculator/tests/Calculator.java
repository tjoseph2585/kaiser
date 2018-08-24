package com.android.calculator.tests;

import org.apache.log4j.Logger;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Properties;

import com.android.calculator.pageobjects.CalculatorPage;
import com.calculator.util.*;

import io.appium.java_client.android.AndroidDriver;
import com.calculator.util.BaseTest;

public class Calculator extends BaseTest {

	private static Logger logger = Logger.getLogger(Calculator.class);
	
	public static Logger getLogger() {
        return logger;
    }
	
	//grouping should be "smoke", "validation", "regression"
	
	@Test (dataProvider="getData",groups = {"smoke"})
	public void VerifyCalculator(String data1, String data2, String data3, String data4) throws Exception {
		getLogger().info("Invoked -VerifyCalculator()- method");
		
		
		//get calculator object 
		CalculatorPage calculatorPage = new CalculatorPage(androidDriver);
		
		//enter data into calculator
		String result = calculatorPage.enterCalculator(data1, data2, data3);
		
		//verify the operation
		Assert.assertEquals(result, data4);
	}
	
	@DataProvider
	public Object[][] getData() {
	 return new Object[][]{
		 {5, 1, "add", 6}, 
		 {5, 1, "minus", 4},
		 {5, 1,"mutiply",5}, 
	  };
    }
}
