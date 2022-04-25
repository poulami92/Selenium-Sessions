package TestNGTutorials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	@Test
	public void dragAndDropTest()
	{
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		WebElement src = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
		
		WebElement target = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		
		Actions action = new Actions(driver);
		
	//	action.clickAndHold(src).moveToElement(target).release().build().perform();
		
		action.dragAndDrop(src, target).build().perform();
		
		driver.quit();
	}
	

}
