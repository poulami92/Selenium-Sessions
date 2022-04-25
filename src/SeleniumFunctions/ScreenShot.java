package SeleniumFunctions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);          //after page loaded fully,timeout for every element to be ready on page
		
		driver.get("https://courses.letskodeit.com/practice");
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\SeleniumFunctions\\image.png"));
		
		                                                
	}

}
