package SeleniumFunctions;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);          //after page loaded fully,timeout for every element to be ready on page
		
		driver.get("https://courses.letskodeit.com/practice");
		
		String parentHandle = driver.getWindowHandle();
		
		driver.findElement(By.id("openwindow")).click();
//		driver.findElement(By.id("opentab")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println(handles);
		
		Iterator<String> it=handles.iterator();
		
	    while(it.hasNext()) {
	    	if(it.next()!=parentHandle) {
	    		
	    		String childHandle=it.next();
	    		driver.switchTo().window(childHandle);
	    		driver.findElement(By.xpath("//input[@placeholder='Search Course']")).sendKeys("java");
	    		driver.close();
	    		break;
	    	}	    	
	    }
		    
    	driver.switchTo().window(parentHandle);
    	System.out.println(driver.getTitle());

		                                                
	}

}
