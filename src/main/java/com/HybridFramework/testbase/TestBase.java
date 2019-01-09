package com.HybridFramework.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HybridFramework.General.BrowserWait;
import com.HybridFramework.General.ElementLocator;
import com.HybridFramework.General.LoadProperties;
import com.HybridFramework.reports.TestReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static  WebDriver driver;
	public FileInputStream file;
	public static Properties OR;
	public File f1;
	public static String confilepath = System.getProperty("user.dir")+"/src/main/java/com/HybridFramework/config/config.properties";
	public static String imagelocation = System.getProperty("user.dir")+"/ScreenShots/";
	public static String ORPath =  System.getProperty("user.dir")+"/src/main/java/com/HybridFramework/config/or.properties";
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public BrowserWait wt;
	public TestReport tr;
	public LoadProperties lp;
	public  ElementLocator el;
	
	public TestBase(){		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);		
	}
	
	
	
	static{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")+"/TestReports/"+formater.format(calendar.getTime())+".html", false);		
	}
	
	
	public void getBrowser(String browser){
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Utilities/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Utilities/chromedriver.exe");
				driver = new ChromeDriver();
			}
			
		}
	}
	
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		tr.getresult(result);		
	}
	
	@BeforeMethod
	public void beforeMethod(Method result){
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+" : test started");
		  
	}
	
	
	@AfterClass(alwaysRun=true)
	public void endTest(){
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}
	
	
	//public static void main(String[] args) throws IOException {
	@Test
		public void TestCase1() throws Exception{	
		wt = new BrowserWait();
		  tr = new TestReport();
		  lp = new LoadProperties();
		  el = new ElementLocator(driver);
		this.getBrowser("chrome");
		
		
		
		String URL = lp.getProperty(confilepath, "url");
		//System.out.println(URL);
		logger.info(URL);
		driver.get(URL);
		wt.genericSetting();
		//WebElement ele = driver.findElement(By.xpath("//*[@id='gb_70']"));
		WebElement ele = el.getElement(ORPath, "username");
		
		wt.explicitWaitMethod(driver, 10, ele);
		//System.out.println(ele.getText());
		logger.info(ele.getText());
		//tb.takeScreenshot("testcase1");
		ele.click();	
	}

}
