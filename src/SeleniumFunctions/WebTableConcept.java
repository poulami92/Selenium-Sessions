package SeleniumFunctions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebTableConcept {

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
//		driver.get("https://freecrm.com/");
//		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("poulami92datta@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Kolkata@1");
    	driver.findElement(By.xpath("//div[text()='Login']")).click();
    	
    	driver.findElement(By.xpath("//span[text()='Contacts']")).click();
    	
    	Actions action = new Actions(driver);
    	action.moveToElement(driver.findElement(By.xpath("//div"))).build().perform();
    	
    	Thread.sleep(5000);
    	
    	int rowNum = driver.findElements(By.xpath("//table//tbody//tr")).size();
    	
    	System.out.println(rowNum);
    	
    	//To find texts
    	
    	//table//tbody//tr[1]//td[2]//a
    	//table//tbody//tr[2]//td[2]//a
    	
    	//To find check box
    	
    	//table//tbody//tr[1]//td[1]//label
    	//table//tbody//tr[2]//td[1]//label
    	
    	//Method - 1
    	
//    	String before_xpath ="//table//tbody//tr[";
//    	String after_xpath="]//a";
//    	
//    	for(int i =1;i<=rowNum;i++)
//    	{
//    		String name_xpath = before_xpath+i+after_xpath;
//    		String name = driver.findElement(By.xpath(name_xpath)).getText();
//    		System.out.println(name);
//    		if(name.contains("poulami"))
//    		{
//    			driver.findElement(By.xpath(before_xpath+i+"]//td[1]//div")).click();
//    			break;
//    		}
//    	}
    	
    	
    	//Method 2
    	
    	driver.findElement(By.xpath("//table//a[contains(text(),'arnab')]//parent::td//preceding-sibling::td//div")).click();
    	driver.findElement(By.xpath("//table//a[contains(text(),'poulami')]//parent::td//preceding-sibling::td//div")).click();
    	
    	
    	
	}

}
