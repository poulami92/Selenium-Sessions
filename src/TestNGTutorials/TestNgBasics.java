package TestNGTutorials;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	@BeforeSuite
	public void setUp()
	{
		System.out.println("setup system property for chrome");
	}
	
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("launch chrome browser");
	}	
		
	@BeforeClass
	public void enterURL()
	{
		System.out.println("enter url");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("login to app");
	}
	
	@Test
	public void googleTitleTest()
	{
		System.out.println("google title test");
	}
	
	@Test
	public void searchTest()
	{
		System.out.println("Search Test");
	}
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("logout from app");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close browser");
	}
	
	@AfterTest
	public void deleteAllCookies()
	{
		System.out.println("delete all cookies");
	}
	
	@AfterSuite
	public void generateReport()
	{
		System.out.println("generate test report");
	}

}
