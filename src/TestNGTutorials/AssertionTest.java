package TestNGTutorials;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	
	
	
  @Test
  public void test1() {	
	  
	  SoftAssert sa1 = new SoftAssert();
	  
	  System.out.println("open browser");
//	  Assert.assertEquals(true, false);                       //hard assertion
	  System.out.println("enter username");
	  System.out.println("enter password");
	  System.out.println("click sign in button");
	  System.out.println("validate home page");
	  sa1.assertEquals(true, false);                          //soft assertion
	  System.out.println("go to deals page");
	  System.out.println("create a contact");
	  
	  sa1.assertAll();
  }
  
  @Test
  public void test2() {	  
	  
	  SoftAssert sa2 = new SoftAssert();
	  System.out.println("logout");
	  sa2.assertEquals(true, true); 
	  sa2.assertAll();
  }
}
