package TestNGTutorials;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleTitleTest {
	
  WebDriver driver;	
	
  
  @BeforeMethod
  public void setUp() {
	  
	    System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("https://www.google.co.in/");
		
  }
  
  @Test()
  public void googleTitleTest() {
	  
	  System.out.println(driver.getTitle());
	  
	  Assert.assertEquals(driver.getTitle(), "Google","Title is not matched");
  }
  
  @Test()
  public void googleLogoTest() {
	  
	  boolean logo = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	  System.out.println(logo);
	  Assert.assertTrue(logo);
  }
  
  @AfterMethod
  public void tearDown() {
	  
	  driver.quit();
	  
  }

  

}
