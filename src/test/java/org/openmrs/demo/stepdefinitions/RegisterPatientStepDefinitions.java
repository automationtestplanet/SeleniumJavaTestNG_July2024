package org.openmrs.demo.stepdefinitions;

import org.openmrs.demo.bdd.testrunner.BddTestNGTestRunner;
import org.openms.demo.pageobjects.Commons;
import org.openms.demo.pageobjects.FindPatientPage;
import org.openms.demo.pageobjects.HomePage;
import org.openms.demo.pageobjects.PatientDetailsPage;
import org.openms.demo.pageobjects.RegistrationPage;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPatientStepDefinitions extends BddTestNGTestRunner{
	
	@Given("user is on the OpenMrs Home Page")
	public void userIsOnTheOpenMrsHomePage() {
		Assert.assertTrue(true);
		Assert.assertTrue(homePage.verfyLogin("Home"));		
	}

	@When("user clicks on {string} Tile")
	public void userClicksOnTile(String tileName) {
		System.out.println("--------------------------------Register Patient--------------------------");
		Assert.assertTrue(homePage.verifyTile("Register a patient"), "Register Patient Tile is not available");
		homePage.clickTile(tileName);
		Assert.assertTrue(registrationPage.verifyRegisterPatientPage("Register a patient"),
				"Register patient Page is not displayed");
	}

	@When("user provides patient details name {string} gender {string} Date of birth {string} address {string} and phone number {string}")
	public void userProvidesPatientDetailsNameGenderDateOfBirthAddressAndPhoneNumber(String name, String gender, String dateOfBirth, String address, String phoneNumber) {
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
	}

	@When("user verifies patient details name {string} gender {string} Date of birth {string} and phone number {string} and clicks confirm")
	public void userVerifiesPatientDetailsNameGenderDateOfBirthAndPhoneNumberAndClicksConfirm(String name, String gender, String dateOfBirth, String phoneNumber) {
		Assert.assertTrue(
				registrationPage.verfyConfirmPage(name, gender, dateOfBirth,phoneNumber),
				"Register details are not displaying properly, Cancelling the register");
		registrationPage.clickConfirm();
	}

	@Then("patient must be registerted with name {string}")
	public void patientMustBeRegistertedWithName(String name) {
		Assert.assertTrue(patientDeailsPage.verifyRegisteredPatientName(name));
	}

	@Then("patient Id must be generated")
	public void patientIdMustBeGenerated() {
		patientId = patientDeailsPage.getPatientId();
		System.out.println(patientId);
		Commons.setPropertyInTestProperties("patient.id", patientId);
	}
}
