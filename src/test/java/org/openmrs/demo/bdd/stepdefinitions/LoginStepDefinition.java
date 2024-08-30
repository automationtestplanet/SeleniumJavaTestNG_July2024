package org.openmrs.demo.bdd.stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	@Given("Launch OpenMRs Login Page")
	public void launchApplication() {
		System.out.println("Open Mrs Application Launched");
	}

	@Given("User is on OpenMRs Login Page")
	public void userIsOnTheOpenMrsLoginPage() {
		System.out.println("User is on Login Page");
	}

	@When("User logins with Username {string} and Password {string}")
	public void userLoginsWithUerNameAndPassword(String userName, String password) {
		System.out.println("User Name: " + userName + " and Passowrd: " + password);
	}

	@When("Clicks Login button")
	public void clickLoginButton() {
		System.out.println("Cliked Login Button");
	}

	@Then("Login should successfull")
	public void verfiyLoginShouldSuccessful() {
		System.out.println("Login Success");
	}

	@Then("Login should fail")
	public void loginShouldFail() {
		System.out.println("Login Failed");
	}

	@Before
	public void beforeHook() {
		System.out.println("Set Chrome Drier Path");
	}

	@After
	public void afterHook() {
		System.out.println("Logout Application");
	}
	
	@Before("@LoginWithValidCredentials")
	public void beforeHookForTag() {
		System.out.println("This before Hook for @LoginWithValidCredentials scenario");
	}
	
	@After("@LoginWithValidCredentials")
	public void afterHookForTag() {
		System.out.println("This after Hook for @LoginWithValidCredentials scenario");
	}
	
	@BeforeStep
	public void beforeStepHook() {
		System.out.println("This is Before Step Hook");
	}
	
	@AfterStep
	public void afterStepHook() {
		System.out.println("This is After Step Hook");
	}
	
	@When("User logins with Username and Password")
	public void userLoginsWithUsernameAndPassword(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    
		List<Map<String,String>> allMapsList =  dataTable.asMaps(String.class,String.class);
		
		for(Map eachMap :allMapsList) {
			System.out.println(eachMap.get("UserName"));
			System.out.println(eachMap.get("Password"));
		}
	}

}
