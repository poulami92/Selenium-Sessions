package TestNGTutorials;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentReportTest {
	
	WebDriver driver;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	
	@BeforeTest
	public void setExtent()
	{
		extentReport = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extentReport.addSystemInfo("Host Name", "Poulami Windows");
		extentReport.addSystemInfo("User Name", "Poulami Datta");
		extentReport.addSystemInfo("Environment", "QA");
	}

  
	@BeforeMethod
	public void setUp()
	{
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();                           
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		driver.get("https://ui.cogmento.com/");
	}
	
	
	
	@Test
	public void freeCrmTitleTest()
	{
		extentTest = extentReport.startTest("freeCrmTitleTest");
		
		String title = driver.getTitle();
		System.out.println(title);
	    Assert.assertEquals(title, "Cogmento CRM1");
	}
	
	public static String getScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\test-output\\FailedScreenShots\\"+screenshotName+datename+".png";
		FileUtils.copyFile(src, new File(dest));
		return dest;
		     
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(LogStatus.FAIL, "Test case Failed "+result.getName());
			extentTest.log(LogStatus.FAIL, "Error "+result.getThrowable());
			String screenshotPath = getScreenShot(driver,result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(LogStatus.PASS, "Passed "+result.getName());
		}
		
		if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(LogStatus.SKIP, "Skipped "+result.getName());
		}
		
		extentReport.endTest(extentTest);
		driver.quit();
	}
	
	@AfterTest
	public void endReport()
	{
		extentReport.flush();
		extentReport.close();
	}
}
