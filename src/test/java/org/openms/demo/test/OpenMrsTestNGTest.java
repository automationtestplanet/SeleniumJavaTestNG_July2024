package org.openms.demo.test;

import org.testng.annotations.Test;

public class OpenMrsTestNGTest extends TestNGBaseClass {

	@Test(priority = 0)
	public void registerPatient() {
		System.out.println("This is Register Patient");
	}

	@Test(priority = 1, dependsOnMethods = "registerPatient")
	public void findPatient() {
		System.out.println("This is Find Patient");
	}

	@Test(priority = 2,enabled = false)
	public void activateVisitsAndAddAttachment() {
		System.out.println("This is Activate Visits and Add Attachments");
	}

	@Test(priority = 3, invocationCount = 4)
	public void deletePatient() {
		System.out.println("This is Delete Patient");
	}

}
