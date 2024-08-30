package org.openmrs.demo.bdd.testrunner;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends BddTestNGTestRunner{
	@AfterStep
	public void addScreenshotToReport(Scenario scenario) throws Exception {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileByteArray = FileUtils.readFileToByteArray(screenshot);
		scenario.embed(fileByteArray, "image/png", "screenshot");
	}
}
