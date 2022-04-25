package SeleniumFunctions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BootStrapDropDown {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//li//label"));
		for(WebElement e : list)
		{
			System.out.println(e.getText());
		}
//		driver.findElement(By.xpath("//label[text()=' Angular']")).click();
		
		
		
	}

}
