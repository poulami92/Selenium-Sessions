package TestNGTutorials;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileDownloadConcept {
	
	WebDriver driver;
	File folder;
	
	
	@BeforeMethod
	public void setUp()
	{
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
        System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        Map<String,Object> prefs = new HashMap<String,Object>();
        
        //the moment i click on download link,there should not be any popup
        prefs.put("profile.default_content_settings.popups", 0);
        
        //Get the path of the folder on basis of UUID gnerated
        prefs.put("download.default_directory", folder.getAbsolutePath());         
   
		
        options.setExperimentalOption("prefs", prefs);
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setCapability(ChromeOptions.CAPABILITY,options);
//        options.merge(cap);
        
		driver = new ChromeDriver(options);                          
		
	}
	
	
	@Test
	public void downloadFileTest() throws InterruptedException
	{
		
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		
		Thread.sleep(2000);
		File listOfFiles[]=folder.listFiles();
//		Assert.assertEquals(listOfFiles.length, is(not(0)));
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file :listOfFiles)
		{
//			Assert.assertEquals(file.length(), is(not(0)));
		   Assert.assertTrue(file.length()>0);
		}
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
		for(File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}

}
