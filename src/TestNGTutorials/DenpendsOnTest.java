package TestNGTutorials;

import org.testng.annotations.Test;

public class DenpendsOnTest {
	

  @Test()
  public void loginTest() {
	  
	  System.out.println("Login test");
	 // int i= 9/0;
  }
  
  @Test(dependsOnMethods="loginTest")
  public void homeTest() {
	  
	  System.out.println("Home page test");
  }
  
  @Test(dependsOnMethods="loginTest")
  public void searchTest() {
	  
	  System.out.println("Search Test");
  }
  
  
}
