package SeleniumFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.get("https://courses.letskodeit.com/practice");
		
		WebElement dropDown = driver.findElement(By.id("carselect"));
		
		Select sel =new Select(dropDown);
		
		sel.selectByVisibleText("Honda");

		                                                
	}

}
