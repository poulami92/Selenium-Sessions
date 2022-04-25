package TestNGTutorials;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterClass;


@Listeners(MethodListener.class)
public class MethodListenerConcept {
  
  @BeforeClass
  public void setUp() {
	  
	  System.out.println("Code in before class");
  }
  
  
  @Test
  public void testMethod1() {
	  System.out.println("code in test method1");
  }
  
  @Test
  public void testMethod2() {
	  System.out.println("code in test method2");
  }

  @AfterClass
  public void cleanUp() {
	  
	  System.out.println("Code in after class");
  }

}
