package com.android.calculator.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.calculator.util.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage {

	//calculator identifier
	public static final String CALCULATOR_ADD = "com.android.calculator2:id/op_add";
	public static final String CALCULATOR_MINUS = "com.android.calculator2:id/op_subtract";
	public static final String CALCULATOR_MUTIPLY = "com.android.calculator2:id/mutiply";
	public static final String CALCULATOR_DIVIDE = "com.android.calculator2:id/divide";
	public static final String CALCULATOR_EQUAL = "com.android.calculator2:id/eq";
	public static final String CALCULATOR_DIGIT = "com.android.calculator2:id/digit_";
	public static final String CALCULATOR_OUTPUT_WINDOW = "android.widget.EditText";
	
	
	private static Logger logger = Logger.getLogger(CalculatorPage.class);
	public static Logger getLogger() {
        return logger;
	}

	AndroidDriver driver;
	public CalculatorPage(AndroidDriver driver) {
		this.driver=driver;
	 }
	
	public String enterCalculator(String number1, String number2, String Operation) throws Exception {
		
		driver.findElementById(CALCULATOR_DIGIT + number1).click();
		driver.findElementById(CALCULATOR_DIGIT + number2).click();
		
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
		
		driver.findElementById(CALCULATOR_EQUAL).click();
		
		String result = driver.findElement(By.className(CALCULATOR_OUTPUT_WINDOW)).getText();
		
		return result;
		
	}
	
	
	
	
}
