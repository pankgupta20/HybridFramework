package com.HybridFramework.GridTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class GridTest {
	 WebDriver driver;
	 public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	 
		@Parameters("myBrowser")
		@BeforeTest
		public  void beforeTest(String myBrowser) throws MalformedURLException{
			 RemoteWebDriver driver = null;
			 
		        if(myBrowser.equals("chrome")){
		            new DesiredCapabilities();
		           // System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Proportional Treaty\\Utilities\\chromedriver.exe");
					DesiredCapabilities capability = DesiredCapabilities.chrome();
		            capability.setBrowserName("chrome");
		            capability.setPlatform(Platform.WINDOWS);
		            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capability);
		        }
		        else if(myBrowser.equals("IE")){
		            new DesiredCapabilities();
					DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
					capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		            capability.setBrowserName("IE");
		            capability.setCapability("requireWindowFocus", true);
		            capability.setPlatform(Platform.WINDOWS);
		            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capability);
		        }else if(myBrowser.equals("firefox")){
		            new DesiredCapabilities();
					DesiredCapabilities capability = DesiredCapabilities.firefox();
					//capability.setCapability("marionette", true);
		            capability.setBrowserName("firefox");
		            capability.setPlatform(Platform.WINDOWS);
		            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capability);
		        }
		        //setting webdriver
		        setWebDriver(driver);
		 
		        getDriver().manage().window().maximize();
		        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
		}

		public WebDriver getDriver() {
	        return dr.get();
	    }
	 
	    public void setWebDriver(RemoteWebDriver driver) {
	        dr.set(driver);
	    }
		
	    @AfterClass
	    public void afterClass(){
	        getDriver().quit();
	        dr.set(null);
	    }

}
