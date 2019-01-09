package com.HybridFramework.General;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.HybridFramework.testbase.TestBase;

public class LoadProperties extends TestBase{
	public static LoadProperties lp;
		
	public void loadProperties(String Fpath) throws IOException{
			OR = new Properties();
			f1 = new File(Fpath);
			file =  new FileInputStream(f1);
			OR.load(file);
		}
	
		public String getProperty(String filepath, String elemname) throws Exception{
			this.loadProperties(filepath);
			return (OR.getProperty(elemname));
		}
		
/*		public static void main(String[] args) throws Exception{
			lp = new LoadProperties();
			String pr = lp.getProperty(ORPath,"username");
			System.out.println(pr);
		}*/
		
		
}
