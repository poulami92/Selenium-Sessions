package TestNGTutorials;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterClass;


@Listeners(TestListener.class)
public class TestListenerConcept {
  
  @BeforeClass
  public void setUp() {
	  
	  System.out.println("Code in before class");
  }
  
  
  @Test
  public void testMethod3() {
	  System.out.println("code in test method3");
  }
  
  @Test
  public void testMethod4() {
	  System.out.println("code in test method4");
  }

  @AfterClass
  public void cleanUp() {
	  
	  System.out.println("Code in after class");
  }

}
