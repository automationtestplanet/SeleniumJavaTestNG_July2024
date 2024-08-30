package org.openmrs.demo.bdd.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "Features",
		glue = "org.openmrs.demo.bdd.stepdefinitions",
		dryRun = false,
		strict = true,
		snippets = SnippetType.CAMELCASE,
		tags="@LoginWithValidMultipleCredentials",
		plugin = {"pretty","html:target"}
		
		)
public class BDDTestRunner {

}
