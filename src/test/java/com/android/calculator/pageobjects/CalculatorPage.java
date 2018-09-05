package com.android.calculator.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.calculator.util.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;

public class CalculatorPage {

	//calculator identifier
	public static final String CALCULATOR_ADD = "com.android.calculator2:id/op_add";
	public static final String CALCULATOR_MINUS = "com.android.calculator2:id/op_sub";
	public static final String CALCULATOR_MUTIPLY = "com.android.calculator2:id/op_mul";
	public static final String CALCULATOR_DIVIDE = "com.android.calculator2:id/op_div";
	public static final String CALCULATOR_EQUAL = "com.android.calculator2:id/eq";
	public static final String CALCULATOR_DIGIT = "com.android.calculator2:id/digit_";
	public static final String CALCULATOR_OUTPUT_WINDOW = "android.widget.EditText";
	public static final String CALCULATOR_CLEAR = "com.android.calculator2:id/clr";
	
	private static Logger logger = Logger.getLogger(CalculatorPage.class);
	public static Logger getLogger() {
        return logger;
	}

	AppiumDriver driver;
	public CalculatorPage(AppiumDriver driver) {
		this.driver=driver;
	 }
	
	public String enterCalculator(String number1, String Operation,  String number2) throws Exception {
		
		driver.findElementById(CALCULATOR_DIGIT + number1).click();
		
		switch (Operation) {
        case "add":
        	driver.findElementById(CALCULATOR_ADD).click();
            break;

        case "subtract":
        	driver.findElementById(CALCULATOR_MINUS).click();
            break;

        case "mutiply":
        	driver.findElementById(CALCULATOR_MUTIPLY).click();
            break;
            
        case "divide":
        	driver.findElementById(CALCULATOR_DIVIDE).click();
            break;
            
        default:
            throw new Exception("unknowm operation");
        }
		
		driver.findElementById(CALCULATOR_DIGIT + number2).click();
		
		driver.findElementById(CALCULATOR_EQUAL).click();
		Thread.sleep(4000);
		String result = driver.findElement(By.className(CALCULATOR_OUTPUT_WINDOW)).getText();
		
		driver.findElementById(CALCULATOR_CLEAR).click();
	
		
		return result;
		
	}
	
	
	
	
}
