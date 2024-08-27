package org.openms.demo.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Commons extends BasePage {

	public Commons(WebDriver driver) {
		super(driver);
	}

	public static Properties testProperties = new Properties();
	static String testFilePath = System.getProperty("user.dir") + "//src//main//resources//test.properties";

	public static void setPropertyInTestProperties(String propertyName, String propertyValue) {
		try {
			FileInputStream testFileInputStream = new FileInputStream(new File(testFilePath));
			testProperties.load(testFileInputStream);
			testProperties.setProperty(propertyName, propertyValue);
			FileOutputStream testOutputStream = new FileOutputStream(new File(testFilePath));
			testProperties.store(testOutputStream, "Updated by Raju Chelle");
		} catch (Exception e) {
			System.out.println("Exception Occured while setting the property to Test Properties: " + e.getCause());
		}
	}

	public static String getPropertyInTestProperties(String propertyName) {
		String propertyValue = null;
		try {
			FileInputStream testFileInputStream = new FileInputStream(new File(testFilePath));
			testProperties.load(testFileInputStream);

			propertyValue = testProperties.getProperty(propertyName);
		} catch (Exception e) {
			System.out.println("Exception Occured while getting the property form Test Properties: " + e.getCause());
		}

		return propertyValue;
	}

	public void captureScreenshot() {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			
			String fileName = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()).replaceAll("[^0-9]", "");
			System.out.println(fileName);
			File destinationPath = new File(
					System.getProperty("user.dir") + "//src//test//resources//Screenshots//"+fileName+".jpg");
			FileUtils.copyFile(screenshot, destinationPath);

		} catch (Exception e) {
			System.out.println("Exception Occured while taking the screenshot: " + e.getCause());
		}
	}

}
