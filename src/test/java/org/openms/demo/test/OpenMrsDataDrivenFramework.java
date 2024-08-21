package org.openms.demo.test;

import org.openms.demo.pageobjects.Commons;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenMrsDataDrivenFramework extends OpenMrsBaseTest{
	
	@Test(dataProvider = "RegisterPatientData")
	public void registerPatient(String name, String gender, String dateOfBirth, String address, String phoneNumber) {
		System.out.println("--------------------------------Register Patient--------------------------");
		Assert.assertTrue(homePage.verifyTile("Register a patient"), "Register Patient Tile is not available");
		homePage.clickTile("Register a patient");
		Assert.assertTrue(registrationPage.verifyRegisterPatientPage("Register a patient"),
				"Register patient Page is not displayed");
		registrationPage.setPatientName(name);
		registrationPage.clickNextButton();
		registrationPage.selectGenderByVisibleText(gender);
		registrationPage.clickNextButton();
		registrationPage.setDateOfBirth(dateOfBirth);
		registrationPage.clickNextButton();
		registrationPage.setAddress(address);
		registrationPage.clickNextButton();
		registrationPage.setPhoneNumber(phoneNumber);
		registrationPage.clickNextButton();
		registrationPage.clickNextButton();
		Assert.assertTrue(
				registrationPage.verfyConfirmPage(name, gender, dateOfBirth,phoneNumber),
				"Register details are not displaying properly, Cancelling the register");
		registrationPage.clickConfirm();
		Assert.assertTrue(patientDeailsPage.verifyRegisteredPatientName(name));
		patientId = patientDeailsPage.getPatientId();
		System.out.println(patientId);
		Commons.setPropertyInTestProperties("patient.id", patientId);
	}

}
