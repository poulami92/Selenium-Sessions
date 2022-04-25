package TestNGTutorials;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ITestResultIntefaceConcept {
	
	
  @Test
  public void testMethod1() {
	  
	  System.out.println("Running-->testmethod1");
	  Assert.assertTrue(false);
  }
  
  @Test
  public void testMethod2() {
	  
	  System.out.println("Running-->testmethod2");
	  Assert.assertTrue(true);
  }
  
  
  @AfterMethod
  public void afterMethod(ITestResult testResult) {
	  
	  if(testResult.getStatus()==ITestResult.FAILURE)
	  {
		  System.out.println("Failed Test-->"+testResult.getMethod().getMethodName());
	  }
	  
	  if(testResult.getStatus()==ITestResult.SUCCESS)
	  {
		  System.out.println("Paased Test-->"+testResult.getName());
	  }
	  
	  
  }

}
