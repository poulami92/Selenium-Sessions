package SeleniumFunctions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalenderPicker2 {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
//        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
//        driver.findElement(By.id("datepicker")).sendKeys("03/16/2024");
//        driver.findElement(By.xpath("//body")).click();
        
        
        driver.get("https://www.goibibo.com/flights/");
        
        WebElement depDate = driver.findElement(By.xpath("//span[text()='Departure']"));
        depDate.click();
        List<WebElement> monthYear = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']//div"));
        
        selectDate("28 August 2022",monthYear);
        
	}
	
	public static void selectDate(String expDate,List<WebElement> monthYear )
	
	{
		String expDay = expDate.substring(0, 2);
		String expMonthYear = expDate.substring(3);
		
		
	       
        String monthYear1= monthYear.get(0).getText();
        String monthYear2= monthYear.get(1).getText();
        
        
//        March 2022
       
        
        while(!monthYear1.equals(expMonthYear) && !monthYear2.equals(expMonthYear) )
        {
        	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
        	
        	monthYear = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']//div"));
            
            monthYear1= monthYear.get(0).getText();
            monthYear2= monthYear.get(1).getText();
            
            
        }
        
        if(monthYear1.equals(expMonthYear))
        {
            driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//p[text()='"+expDay+"']")).click();
        }
        else
        {
        	driver.findElement(By.xpath("//div[@class='DayPicker-Month'][2]//p[text()='"+expDay+"']")).click();
        }
	}

}
