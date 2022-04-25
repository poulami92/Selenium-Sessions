package DataDrivenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ReadExeclFile {

	public static void main(String[] args) {
		
		
	
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\com\\testdata\\eBayRegData.xlsx");
		
		String fname = reader.getCellData("RegTestData", "Firstname", 2);
		System.out.println(fname);
		
		String lname = reader.getCellData("RegTestData", "Lastname", 2);
		System.out.println(lname);
		
		String email = reader.getCellData("RegTestData", "Email", 2);
		System.out.println(email);
		
		String pwd = reader.getCellData("RegTestData", "Password", 2);
		System.out.println(pwd);
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("https://www.ebay.com/");
		driver.findElement(By.linkText("register")).click();
		
		driver.findElement(By.id("firstname")).sendKeys(fname);
		driver.findElement(By.id("lastname")).sendKeys(lname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT")).click();
	
	}

}
