package SeleniumFunctions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementVisibility {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		driver.get("https://courses.letskodeit.com/practice");
		
		Boolean IsVisible = driver.findElement(By.id("displayed-text")).isDisplayed();
		
		System.out.println(IsVisible);
		
		driver.findElement(By.id("enabled-button")).click();
		
		Boolean IsEnable = driver.findElement(By.id("enabled-example-input")).isEnabled();
		
		System.out.println(IsEnable);
		
		Boolean IsSelected = driver.findElement(By.id("bmwradio")).isSelected();
		
		System.out.println(IsSelected);
		
		driver.quit();
		
		
	}

}
