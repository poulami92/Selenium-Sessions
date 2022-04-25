package SeleniumFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                             //launch chrome
		
		driver.get("https://courses.letskodeit.com/practice");
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();   //Clicking on Alert button
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());                              //Getting text on Alert box
		
		String alertMsg = alert.getText();
		
		if (alertMsg.equals("Hello , share this practice page and share your knowledge")) {
			
			System.out.println("Corret message on alert box");
		}
		
		else {
			
			System.out.println("Incorrect alert message");
		}
		
		alert.accept();                                                   //Click on Ok button on Alert box
		
		Thread.sleep(5000);                                               //Waiting for 5 sec
		
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();   //Clicking on Confirm button
		
		alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.dismiss();                                                   //Click on Cancel button on Confirm box


	}
	
	

}
