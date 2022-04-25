package TestNGTutorials;

import org.testng.annotations.Test;

public class InvocationCountTest {
	

  @Test(invocationCount=10)
  public void sum() {
	  
	  int a =10;
	  int b =20;
	  
	  System.out.println(a+b);
	 
  }
  
  
  
  
}
