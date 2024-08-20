package org.openms.demo.test;

import org.openms.demo.pageobjects.Commons;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenMrsKeywordDrivenFramework extends OpenMrsBaseTest {

	@Test()
	public void registerPatient() {
		System.out.println("--------------------------------Register Patient--------------------------");
		Assert.assertTrue(homePage.verifyTile("Register a patient"), "Register Patient Tile is not available");
		homePage.clickTile("Register a patient");
		Assert.assertTrue(registrationPage.verifyRegisterPatientPage("Register a patient"),
				"Register patient Page is not displayed");
		registrationPage.setPatientName("Ganesh, M");
		registrationPage.clickNextButton();
		registrationPage.selectGenderByVisibleText("Male");
		registrationPage.clickNextButton();
		registrationPage.setDateOfBirth("1,January,1990");
		registrationPage.clickNextButton();
		registrationPage.setAddress("Do.No - 8/168, S R Nagar", "Hyderabad", "Telangana", "India", "500038");
		registrationPage.clickNextButton();
		registrationPage.setPhoneNumber("9876543210");
		registrationPage.clickNextButton();
		registrationPage.clickNextButton();
		Assert.assertTrue(
				registrationPage.verfyConfirmPage("Ganesh, M", "Male", "1,January,1990", "Hyderabad", "9876543210"),
				"Register details are not displaying properly, Cancelling the register");
		registrationPage.clickConfirm();
		Assert.assertTrue(patientDeailsPage.verifyRegisteredPatientDetails("Ganesh"));
		patientId = patientDeailsPage.getPatientId();
		System.out.println(patientId);
		Commons.setPropertyInTestProperties("patient.id", patientId);
	}

	@Test()
	public void findPatient() {
		System.out.println("--------------------------------Find Patient--------------------------");
		Assert.assertTrue(homePage.verifyTile("Find Patient Record"), "Find Patient Record Tile is not available");
		homePage.clickTile("Find Patient Record");
		Assert.assertTrue(findPatientPage.verifyFindPatientPage("Find Patient Record"),
				"Find Patient page is not displayed");
		String patientId = Commons.getPropertyInTestProperties("patient.id");
		findPatientPage.setPatientIdInSearchFiled(patientId);
		String searchedPatientID = findPatientPage.getFindPatientTableColumnValue("Identifier");
		Assert.assertTrue(searchedPatientID.contains(patientId), "Searched record is displaying wrong");
		findPatientPage.clickSearchedRecord();
		String actualPatientId = patientDeailsPage.getPatientId();
		Assert.assertTrue(actualPatientId.equals(patientId), "Patient Details are incorrect");
	}

	@Test()
	public void activateVisitsAndAddAttachment() {
		System.out.println(
				"--------------------------------Active Visits and Add Attachments --------------------------");
		homePage.clickTile("Find Patient Record");
		findPatientPage.setPatientIdInSearchFiled(Commons.getPropertyInTestProperties("patient.id"));
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

	@Test()
	public void deletePatient() {
		System.out.println("--------------------------------Delete Patient --------------------------");
		homePage.clickTile("Find Patient Record");
		findPatientPage.setPatientIdInSearchFiled(Commons.getPropertyInTestProperties("patient.id"));
		findPatientPage.clickSearchedRecord();
		patientDeailsPage.clickDeletePatientLink();
		patientDeailsPage.setDeleteReason("Other");
		patientDeailsPage.clickDeletePatientCofirmButton();
		findPatientPage.setPatientIdInSearchFiled(Commons.getPropertyInTestProperties("patient.id"));
		Assert.assertTrue(patientDeailsPage.verifyErrorMessage(), "Patient Record is not deleted");
	}
}
