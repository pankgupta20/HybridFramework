package com.HybridFramework.screenshots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.HybridFramework.testbase.TestBase;

public class TakeScreenshot extends TestBase{
	public  String takeScreenshot(String imagename) throws IOException{
		if(imagename.equals("")){
			imagename="Blank";
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualimage = imagelocation+imagename+"_"+formater.format(calendar.getTime())+".png";
		File destFile = new File(actualimage);
		FileUtils.copyFile(image, destFile);	
		return actualimage;
	}
}
