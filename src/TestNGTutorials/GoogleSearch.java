package TestNGTutorials;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch {
	
	@Test
	public void GoogleSearchTest()
	{
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing");
		List<WebElement> list = driver.findElements(By.xpath("//ul//li//div[@class='wM6W7d']/span"));
		for(WebElement e : list)
		{
			System.out.println(e.getText());
			if(e.getText().equals("testing types"))
			{
				e.click();
				break;
			}
		}
		
		driver.quit();
	}

}
