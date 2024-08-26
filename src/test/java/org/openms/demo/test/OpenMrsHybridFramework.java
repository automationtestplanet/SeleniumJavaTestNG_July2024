package org.openms.demo.test;

import java.util.Map;

import org.openms.demo.pageobjects.Commons;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenMrsHybridFramework extends OpenMrsBaseTest {

	@Test(dataProvider = "TestDataProvider")
	public void registerPatientTest(Map<String, String> testData) {
		System.out.println("--------------------------------Register Patient--------------------------");
		Assert.assertTrue(homePage.verifyTile("Register a patient"), "Register Patient Tile is not available");
		homePage.clickTile("Register a patient");
		Assert.assertTrue(registrationPage.verifyRegisterPatientPage("Register a patient"),
				"Register patient Page is not displayed");
		registrationPage.setPatientName(testData.get("Name"));
		registrationPage.clickNextButton();
		registrationPage.selectGenderByVisibleText(testData.get("Gender"));
		registrationPage.clickNextButton();
		registrationPage.setDateOfBirth(testData.get("DateOfBirth"));
		registrationPage.clickNextButton();
		registrationPage.setAddress(testData.get("Address"));
		registrationPage.clickNextButton();
		registrationPage.setPhoneNumber(testData.get("PhoneNumber"));
		registrationPage.clickNextButton();
		registrationPage.clickNextButton();
		Assert.assertTrue(
				registrationPage.verfyConfirmPage(testData.get("Name"), testData.get("Gender"),
						testData.get("DateOfBirth"), testData.get("PhoneNumber")),
				"Register details are not displaying properly, Cancelling the register");
		registrationPage.clickConfirm();
		Assert.assertTrue(patientDeailsPage.verifyRegisteredPatientName(testData.get("Name")));
		patientId = patientDeailsPage.getPatientId();
		System.out.println(patientId);
		Commons.setPropertyInTestProperties("patient.id", patientId);
	}

	@Test(dataProvider = "TestDataProvider")
	public void findPatientTest(Map<String, String> testData) {
		System.out.println("--------------------------------Find Patient--------------------------");
		Assert.assertTrue(homePage.verifyTile("Find Patient Record"), "Find Patient Record Tile is not available");
		homePage.clickTile("Find Patient Record");
		Assert.assertTrue(findPatientPage.verifyFindPatientPage("Find Patient Record"),
				"Find Patient page is not displayed");
		findPatientPage.setPatientIdInSearchFiled(testData.get("Name"));
		findPatientPage.clickSearchedRecord();
		Assert.assertTrue(patientDeailsPage.verifyRegisteredPatientName(testData.get("Name")));
	}

	@Test(dataProvider = "TestDataProvider")
	public void activateVisitsAndAddAttachmentTest(Map<String, String> testData) {
		System.out.println(
				"--------------------------------Active Visits and Add Attachments --------------------------");
		homePage.clickTile("Find Patient Record");
		findPatientPage.setPatientIdInSearchFiled(testData.get("Name"));
		findPatientPage.clickSearchedRecord();
		patientDeailsPage.clickActiveVisits();
		patientDeailsPage.clickActiveVisitsConfirmButton();
		Assert.assertTrue(patientDeailsPage.verifyEndVisitsLink(), "Start Visits not activated");
		patientDeailsPage.clickAttachmentsLink();
		Assert.assertTrue(patientDeailsPage.verifyClickDropButton(), "Click Drop button is not displayed");
		patientDeailsPage.clickDropButton();
		patientDeailsPage.uploadFileFromWindowPopup("UploadFile.pdf");
		patientDeailsPage.setCaption("File1");
		patientDeailsPage.clickUploadButton();
		Assert.assertTrue(patientDeailsPage.verifyUploadedFile("File1"), "File Upload Failed");
	}

	@Test(dataProvider = "TestDataProvider")
	public void deletePatientTest(Map<String, String> testData) {
		System.out.println("--------------------------------Delete Patient --------------------------");
		homePage.clickTile("Find Patient Record");
		findPatientPage.setPatientIdInSearchFiled(testData.get("Name"));
		findPatientPage.clickSearchedRecord();
		patientDeailsPage.clickDeletePatientLink();
		patientDeailsPage.setDeleteReason("Other");
		patientDeailsPage.clickDeletePatientCofirmButton();
		findPatientPage.setPatientIdInSearchFiled(Commons.getPropertyInTestProperties("patient.id"));
		Assert.assertTrue(patientDeailsPage.verifyErrorMessage(), "Patient Record is not deleted");
	}

}
