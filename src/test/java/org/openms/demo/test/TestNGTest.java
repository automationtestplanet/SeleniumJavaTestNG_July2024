package org.openms.demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTest extends TestNGBaseClass {
	
	
  @Test
  public void test1() {
	  System.out.println("This is Test1");
	  Assert.assertEquals(true, true);
  }
  
  @Test
  public void test2() {
	  System.out.println("This is Test2");
	  Assert.assertTrue(true);
  }
  
  @Test
  public void test3() {
	  System.out.println("This is Test3");
	  Assert.assertTrue(false);
  }
  
}
