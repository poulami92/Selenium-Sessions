package TestNGTutorials;

import org.testng.annotations.Test;

public class ExpectedExceptionTest {
	
	@Test(expectedExceptions=NumberFormatException.class)
	  public void Test1() {
		  
		 String x="100A";
		 Integer.parseInt(x);
	  }
}
