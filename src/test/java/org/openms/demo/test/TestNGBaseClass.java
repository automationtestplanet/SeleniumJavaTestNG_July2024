package org.openms.demo.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGBaseClass {

	 @BeforeSuite(alwaysRun = true)
	  public void beforeSuite() {
		  System.out.println("This is Before Suit");
	  }
	  
	  @AfterSuite(alwaysRun = true)
	  public void afterSuite() {
		  System.out.println("This is After Suit");
	  }
	  
	  @BeforeTest(alwaysRun = true)
	  public void befoeTest() {
		  System.out.println("This is Before Test");
	  }
	  
	  @AfterTest(alwaysRun = true)
	  public void afterTest() {
		  System.out.println("This is After Test");
	  }
	  
	  @BeforeClass(alwaysRun = true)
	  public void beforeClass() {
		  System.out.println("This is Before Class");
	  }
	  
	  @AfterClass(alwaysRun = true)
	  public void afterClass() {
		  System.out.println("This is After Class");
	  }
	  
	  @BeforeMethod(alwaysRun = true)
	  public void beforeMethod() {
		  System.out.println("This is Before Method");
	  }
	  
	  @AfterMethod(alwaysRun = true)
	  public void afterMethod() {
		  System.out.println("This is After Method");
	  }
}
