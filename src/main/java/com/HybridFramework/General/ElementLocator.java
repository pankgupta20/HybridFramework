package com.HybridFramework.General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.HybridFramework.testbase.TestBase;

public class ElementLocator extends TestBase {
	private static  WebDriver driver;
	private static LoadProperties lp;
	private static  TestBase tb;
	
	public ElementLocator(WebDriver driver){
		super();
		
	}
	
	
		
	public static WebElement getLocator(String locator) throws Exception{
		tb = new TestBase();
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		
		if(locatorType.toLowerCase().equals("id")){
			return driver.findElement(By.id(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("class")) || (locatorType.toLowerCase().equals("classname"))) {
			return driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("name")){
			return driver.findElement(By.name(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag"))){
			return driver.findElement(By.tagName(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("link")) || (locatorType.toLowerCase().equals("linktext"))){
			return driver.findElement(By.linkText(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("partialtext")) || (locatorType.toLowerCase().equals("partiallinktext"))){
			return driver.findElement(By.partialLinkText(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("css")) || (locatorType.toLowerCase().equals("cssselector"))){
			return driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("xpath")){
			return driver.findElement(By.xpath(locatorValue));
		}
		else 
			throw new Exception("Unknown locator type: '"+ locatorType+'"');
	}	

	
	public WebElement getLocators(String locator) throws Exception{
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		
		if(locatorType.toLowerCase().equals("id")){
			return driver.findElement(By.id(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("class")) || (locatorType.toLowerCase().equals("classname"))) {
			return driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("name")){
			return driver.findElement(By.name(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag"))){
			return driver.findElement(By.tagName(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("link")) || (locatorType.toLowerCase().equals("linktext"))){
			return driver.findElement(By.linkText(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("partialtext")) || (locatorType.toLowerCase().equals("partiallinktext"))){
			return driver.findElement(By.partialLinkText(locatorValue));
		}
		else if((locatorType.toLowerCase().equals("css")) || (locatorType.toLowerCase().equals("cssselector"))){
			return driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("xpath")){
			return driver.findElement(By.xpath(locatorValue));
		}
		else 
			throw new Exception("Unknown locator type: '"+ locatorType+'"');
	}	

	
	public WebElement getElement(String filepath, String locator) throws Exception{
		lp = new LoadProperties();
		lp.loadProperties(filepath);
		System.out.println(filepath);
		String elepath = lp.getProperty(filepath, locator);
		System.out.println(elepath);
		return getLocator(elepath);
		
	}
	

	public WebElement getElements(String filepath, String locator) throws Exception{
		lp.loadProperties(filepath);
		return getLocator(OR.getProperty(locator));
	}
	
	
	public static void main(String[] args) throws Exception{
		/*el = new ElementLocator(driver);
		WebElement pr1 = el.getElement(ORPath,"username");*/
		
		
		tb.getBrowser("chrome");
		lp.loadProperties(confilepath);
		String URL = lp.getProperty(confilepath, "url");
		TestBase.driver.get(URL);
		//tb.driver.get("http://www.google.com");
		//System.out.println(pr1);
	}

	
}
