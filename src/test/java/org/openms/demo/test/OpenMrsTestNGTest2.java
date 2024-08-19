package org.openms.demo.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenMrsTestNGTest2 extends TestNGBaseClass {

	@Test(groups = { "SmokeTest", "SanityTest", "RegressionTest" }, priority = 0)
	@Parameters({ "UserName", "Password" })
	public void registerPatient(String userName, String password) {
		System.out.println("This is Register Patient");
		System.out.println("UserName: " + userName);
		System.out.println("Password: " + password);
		Assert.assertEquals(true, true);
	}

	@Test(groups = { "SanityTest", "RegressionTest" }, priority = 1)
	public void findPatient() {
		System.out.println("This is Find Patient");
		Assert.assertEquals(true, true);
	}

	@Test(groups = "RegressionTest", priority = 2)
	public void activateVisitsAndAddAttachment() {
		System.out.println("This is Activate Visits and Add Attachments");
		Assert.assertEquals(true, true);
	}

	@Test(groups = "RegressionTest",priority = 3)
	public void deletePatient() {
		System.out.println("This is Delete Patient");
		Assert.assertEquals(true, true);
	}

}
