package org.openms.demo.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openms.demo.pageobjects.Commons;
import org.openms.demo.pageobjects.ExcelUtils;
import org.openms.demo.pageobjects.FindPatientPage;
import org.openms.demo.pageobjects.HomePage;
import org.openms.demo.pageobjects.LoginPage;
import org.openms.demo.pageobjects.PatientDetailsPage;
import org.openms.demo.pageobjects.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class OpenMrsBaseTest {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public RegistrationPage registrationPage;
	public PatientDetailsPage patientDeailsPage;
	public FindPatientPage findPatientPage;
	public String patientId;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//main//resources//DriverFiles//chrome//127//chromedriver.exe");
	}

	@BeforeTest(alwaysRun = true)
	public void befoeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Commons.getPropertyInTestProperties("url"));
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		patientDeailsPage = new PatientDetailsPage(driver);
		findPatientPage = new FindPatientPage(driver);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "UserName", "Password", "Module" })
	public void beforeMethod(String userName, String password, String module) {
		loginPage.loginToOpenMrs(userName, password, module);
		Assert.assertTrue(homePage.verfyLogin("Home"));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		try {
			Thread.sleep(5000);
			homePage.clickLogout();
			Thread.sleep(5000);
			Assert.assertTrue(loginPage.verifyLoginPage());
		} catch (Exception e) {
			System.out.println("Exception Occured while clicking Logout: " + e.getMessage());
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		loginPage = null;
		homePage = null;
		registrationPage = null;
		patientDeailsPage = null;
		findPatientPage = null;
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("Test Ended");
	}
	
	@DataProvider(name="RegisterPatientData")
	public Iterator<String[]> registerPatientData() {
		List<String[]> testData = ExcelUtils.readDataFromExcel(System.getProperty("user.dir")+Commons.getPropertyInTestProperties("test.data.excel.file"), "RegisterPatientDetails");
		return testData.iterator();
	}

}
