package SeleniumFunctions;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("poulami92datta@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Kolkata@1");
    	WebElement loginBtn=driver.findElement(By.xpath("//div[text()='Login']"));
		
//		flash(loginBtn,driver);
    	
//		drawBroder(loginBtn,driver);
    	
//		generateAlert("There is an issue with Login button",driver);
    	
//		clickElement(loginBtn,driver);
//		Thread.sleep(5000);
		
//		pageRefresh(driver);
		
//		System.out.println(getPageTitle(driver));
		
//    	System.out.println(getPageText(driver));
		
//		scrollPageDown(driver);
		
//		scrollIntoView(driver);
		                                                
	}
	
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		String highlightColor = "rgb(0,200,0)";
		
		for(int i=0;i<10;i++) {
			js.executeScript("arguments[0].style.backgroundColor='"+highlightColor+"'", element);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			js.executeScript("arguments[0].style.backgroundColor='"+bgcolor+"'", element);
			try {
				Thread.sleep(2000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void drawBroder(WebElement element,WebDriver driver) throws IOException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\SeleniumFunctions\\element.png"));
		
	}
	
	public static void generateAlert(String message,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	//go to 1st history on the browser and loads that page
	public static void pageRefresh(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");             
	}
	
	public static String getPageTitle(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title =js.executeScript("return document.title").toString();
		return title;
	}

	
	//To get entire text of page
	public static String getPageText(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String pageText =js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	
	public static void scrollPageDown(WebDriver driver)
	{
	
		driver.get("https://courses.letskodeit.com/practice");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollIntoView(WebDriver driver)
	{
	
		driver.get("https://courses.letskodeit.com/practice");
		WebElement privacyLink = driver.findElement(By.linkText("Privacy Policy"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",privacyLink);
		
	}
}
