package TestNGTutorials;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryLogicTest {
	
  	
  @Test(/* retryAnalyzer=TestNGTutorials.RetryAnalyzer.class */)
  public void Test1() {
	  
	  Assert.assertEquals(true, false);
  }
  
  @Test
  public void Test2() {
	  
	  Assert.assertEquals(true, false);
  }
}
