package DataDrivenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class WriteExcelFile {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\com\\testdata\\eBayRegData.xlsx");
		int row=reader.getRowCount("RegTestData");
		
		reader.addColumn("RegTestData", "Status");
		for(int rownum=2;rownum<=5;rownum++)
		{
			String fname = reader.getCellData("RegTestData", "Firstname", rownum);
			System.out.println(fname);
			
			String lname = reader.getCellData("RegTestData", "Lastname", rownum);
			System.out.println(lname);
			
			String email = reader.getCellData("RegTestData", "Email", rownum);
			System.out.println(email);
			
			String pwd = reader.getCellData("RegTestData", "Password", rownum);
			System.out.println(pwd);
			
	        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();                           //launch chrome
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			
			driver.get("https://www.facebook.com");
			driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
			
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fname);
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lname);
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(pwd);
			Select sel = new Select(driver.findElement(By.xpath("//select[@id='year']")));
			sel.selectByVisibleText("1990");
			driver.findElement(By.xpath("//input[@type='radio' and @value='1']")).click();
			driver.findElement(By.xpath("//button[text()='Sign Up' and @name='websubmit']")).click();
			
			reader.setCellData("RegTestData", "Status", rownum, "Pass");
			driver.close();

	   }
		
   }

}
