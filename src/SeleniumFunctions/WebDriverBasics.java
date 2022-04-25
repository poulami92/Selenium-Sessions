package SeleniumFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome

		driver.get("https://www.google.com");                            //open google page
		
		String title = driver.getTitle();                               //get title of the page
		
		System.out.println(title);
		
		if(title.equals("Google")) {
			
			System.out.println("correct title");
		}
		else
		{
			System.out.println("incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());                       //get current url of the page
//		System.out.println(driver.getPageSource());                       //get complete page source code
		
		driver.quit();                                                   //close all browser sessions
	}

}
