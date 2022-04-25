package SeleniumFunctions;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HeadlessChrome {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);                             //launch chrome
		
		
		driver.manage().deleteAllCookies();
		
       driver.get("https://courses.letskodeit.com/practice");
		
		List<WebElement> list =driver.findElements(By.tagName("a"));
		System.out.println("Count of links :"+list.size());
		
		for(WebElement e : list) {
			
			System.out.println(e.getText());
		}
		
		                                                
	}

}
