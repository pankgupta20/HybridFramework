package com.HybridFramework.General;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.HybridFramework.testbase.TestBase;

public class BrowserWait extends TestBase {
	public void genericSetting(){
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public WebElement explicitWaitMethod(WebDriver driver, long time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	@SuppressWarnings("deprecation")
	public WebElement explicitWaitwithPolling(WebDriver driver, long time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
