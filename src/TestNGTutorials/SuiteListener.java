package TestNGTutorials;


import org.testng.ISuite;
import org.testng.ISuiteListener;


public class SuiteListener implements ISuiteListener {
	
	public void onStart(ISuite suite)
	{
		System.out.println("On Start Suite");
	}
	
	public void onFinish(ISuite suite)
	{
		System.out.println("On Finish Suite");
	}


}
