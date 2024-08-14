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

	 @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("This is Before Suit");
	  }
	  
	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("This is After Suit");
	  }
	  
	  @BeforeTest
	  public void befoeTest() {
		  System.out.println("This is Before Test");
	  }
	  
	  @AfterTest
	  public void afterTest() {
		  System.out.println("This is After Test");
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("This is Before Class");
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  System.out.println("This is After Class");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("This is Before Method");
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is After Method");
	  }
}
