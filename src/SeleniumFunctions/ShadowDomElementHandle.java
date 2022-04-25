package SeleniumFunctions;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ShadowDomElementHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                             //launch chrome
		
//		driver.get("https://www.amazon.in/gp/css/summary/print.html/ref=oh_aui_ajax_invoice?ie=UTF8&orderID=403-5534475-7169162");
//		
////		document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar')
////		.shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cr-button')
//		
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("9933095723");
//		driver.findElement(By.id("continue")).click();
//		
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("my1stlovegp");
//		driver.findElement(By.id("signInSubmit")).click();
//		
//		Thread.sleep(3000);
//		
//		driver.findElement(By.linkText("Print this page for your records.")).click();
//	
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		
//		WebElement printElm = (WebElement) js.executeScript("return document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar')\r\n"
//				+ "		.shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cr-button');");
//		
//		js.executeScript("arguments[0].click();",printElm);
		
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		
		driver.get("chrome://downloads/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('downloads-manager')"
				+ ".shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#toolbar')"
				+ ".shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput');");
		js.executeScript("arguments[0].setAttribute('value','Admin');",searchBox);
		

	}
	
	

}
