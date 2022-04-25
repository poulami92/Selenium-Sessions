package SeleniumFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MouseMovement {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		Actions action =new Actions(driver);
		
		WebElement destElem = driver.findElement(By.id("mousehover"));
		
		action.moveToElement(destElem).build().perform();
		
		driver.findElement(By.linkText("Top")).click();
		                                                
	}

}
