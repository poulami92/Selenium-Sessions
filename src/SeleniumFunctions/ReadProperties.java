package SeleniumFunctions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadProperties {
	
    static WebDriver driver;


	public static void main(String[] args) throws IOException {
		
		Properties prop =new Properties();
		FileInputStream ip =new FileInputStream("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\SeleniumFunctions\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("URL");
		System.out.println(browser);
		
		
		if(browser.equals("chrome")) {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();                          
		
		}
		
		else if(browser.equals("FF")) {
			
	     System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\geckodriver.exe");
		 driver = new FirefoxDriver();                          
		 
        }
		
		driver.get(url);
		
	}

}
