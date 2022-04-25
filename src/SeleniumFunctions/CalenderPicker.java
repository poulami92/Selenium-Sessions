package SeleniumFunctions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalenderPicker {

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
//		driver.get("https://freecrm.com/");
//		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("poulami92datta@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Kolkata@1");
    	driver.findElement(By.xpath("//div[text()='Login']")).click();
    	
    	driver.findElement(By.xpath("//span[text()='Calendar']")).click();
    	
    	Actions action = new Actions(driver);
    	action.moveToElement(driver.findElement(By.xpath("//div"))).build().perform();
    	
    	Thread.sleep(3000);
    	
    	driver.findElement(By.xpath("//div[@class='rbc-month-view']//div[@class='rbc-date-cell']/a[text()='12']")).click();
    	
	}

}
