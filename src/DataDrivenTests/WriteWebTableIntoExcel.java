package DataDrivenTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WriteWebTableIntoExcel {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();                           //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);             //timeout for page loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\com\\testdata\\WebTableData.xlsx");
		
		//table[@id='customers']//tr[2]/td[3]
		
		String beforeXpath = "//table[@id='customers']//tr[";
		String afterXpath = "]/td[";
		
		for(int i=2;i<=rowCount;i++)
		{
			for(int j=1;j<=colCount;j++)
			{
				String actualXpath =beforeXpath+i+afterXpath+j+"]";
				String item =driver.findElement(By.xpath(actualXpath)).getText();
				//table[@id='customers']//th[2]
				String colNameXapth = "//table[@id='customers']//th["+j+"]";
				String colName = driver.findElement(By.xpath(colNameXapth)).getText();
				reader.setCellData("WebData", colName, i, item);
				
			}
			//System.out.println("\n");
		}

	}

}
