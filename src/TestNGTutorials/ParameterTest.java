package TestNGTutorials;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ParameterTest {
	

  WebDriver driver;
	
	
 @BeforeMethod
 @Parameters({"browser"})
 public void beforeMethod(String browser) {
	 
	   if(browser.equals("chrome")) {
	 
	    System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	   }
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
 }
	
	
  @Test
  @Parameters({"url","emailid"})
  public void yahooLoginTest(String url,String eamilid) {
	  	  
	  driver.get(url);
	  driver.findElement(By.linkText("Sign in")).click();
	  driver.findElement(By.id("login-username")).sendKeys(eamilid);
	  driver.findElement(By.id("login-signin")).click();
  }
  

  @AfterMethod
  public void afterMethod() {
  }

}
