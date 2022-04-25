package TestNGTutorials;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class GoogleTest {
	
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
  }
  
  @Test()
  public void googleLogoTest() {
	  
	  boolean logo = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	  System.out.println(logo);
  }
  
  @Test()
  public void googleMailLinkTest() {
	  
	  boolean email = driver.findElement(By.linkText("Gmail1")).isDisplayed();
	  System.out.println(email);
  }

  @AfterMethod
  public void tearDown() {
	  
	  driver.quit();
	  
  }

  
}
