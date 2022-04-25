package SeleniumFunctions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws MalformedURLException {
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
    	List<WebElement> links = driver.findElements(By.tagName("a"));
    	links.addAll(driver.findElements(By.tagName("img")));
    	System.out.println("size of full links and images :"+links.size());
    	
    	List<WebElement> activeLinks = new ArrayList<WebElement>();
    	for(WebElement e : links)
    	{
    		if(e.getAttribute("href")!=null && (!e.getAttribute("href").contains("javascript"))) {
    			
    			activeLinks.add(e);
    		}
    	}
    	System.out.println("size of active links and images :"+activeLinks.size());
    	
    	
    	//200--> ok
    	//404--> not found
    	//500--> internal error
    	//400--> bad request
    	
    	for (WebElement e: activeLinks) {
    		
    		URL url = new URL(e.getAttribute("href"));             //convert href attribute value to URL class object
    		try {
    			
    			//open a connection to the remote url and returns HttpURLConnection object to call http methods later
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.connect();
				String response = connection.getResponseMessage();
				connection.disconnect();
				System.out.println(e.getAttribute("href")+"-->"+response);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}

	}

}
