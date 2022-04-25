package TestNGTutorials;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MethodListener implements IInvokedMethodListener {
	
	//Run before and after every method invocation
	
	public void beforeInvocation(IInvokedMethod method,ITestResult testResult) {
		
		System.out.println("before invocation-->"+testResult.getName());
		
	}
	
    public void afterInvocation(IInvokedMethod method,ITestResult testResult) {
    	
    	System.out.println("after invocation-->"+testResult.getName());
		
	}

}
