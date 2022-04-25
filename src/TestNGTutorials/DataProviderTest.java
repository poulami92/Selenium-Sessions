package TestNGTutorials;

import org.testng.annotations.Test;

import com.excel.utility.Testutil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderTest {
	
	WebDriver driver;
  
  @BeforeMethod
  public void setUp() {
	  
	    System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("https://www.ebay.com/");
		driver.findElement(By.linkText("register")).click();
  }
  
  
  @Test(dataProvider="getTestData")
  public void eBayReg(String fname,String lname,String email,String pwd) {
	  
	    driver.findElement(By.id("firstname")).clear();
	    driver.findElement(By.id("firstname")).sendKeys(fname);
	    driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lname);
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
  }
  
  @DataProvider
  public Iterator<Object[]> getTestData()
  {
	  ArrayList<Object[]> testdata=Testutil.getDataFromExcel();
	  return testdata.iterator();
	  
  }
  

  @AfterMethod
  public void tearDown() {
	  
	  driver.quit();
  }

}
