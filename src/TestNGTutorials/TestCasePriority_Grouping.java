package TestNGTutorials;

import org.testng.annotations.Test;

public class TestCasePriority_Grouping {
	

  @Test(priority=3,groups="Title")
  public void Test1() {
  }
  
  @Test(priority=1,groups="Title")
  public void Test2() {
  }
  
  @Test(priority=4,groups="Logo")
  public void Test3() {
  }
  
  @Test(priority=2,groups="Logo")
  public void Test4() {
  }
}
