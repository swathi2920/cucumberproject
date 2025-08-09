package com.casestudy.cucumber.setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	// Implement code here
	public Properties properties;
	public final String propertyFilePath= "cucumberproject/src/test/java/com/casestudy/cucumber/configs/Configuration.properties";
	
	public ConfigFileReader() {
	    // implement code to load and read the properties
	    BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			
		}		
	}
	
	public String getBrowserName() {
		//read a property named 'browser' from a configuration file	
		String browsername = properties.getProperty("browser");
		if(browsername!= null) {
		    return browsername;
		}
		return "";
	}	 	  	  		 	     	     	      	 	
	
	public String getDriverName() {
	    //read a property named 'drivername' from a configuration file
	    String driverName = properties.getProperty("drivername");
		if(driverName!= null) {
		    return driverName;
		}
		return "";
	}
	
	public String getDriverPath() {
	    //read a property named 'driverpath' from a configuration file	
	    String driverPath = properties.getProperty("driverpath");
		if(driverPath!= null) {
		    return driverPath;
		}
		return "";
	}
	
	public String getApplicationUrl() {
	    //read a property named 'mainurl' from a configuration file	
	    String url = properties.getProperty("mainurl");
		if(url != null) {
		    return url;
		}
		return "";
	}
	
	public String getApplicationChildUrl() {
	    //read a property named 'childurl' from a configuration file 
	    String childurl = properties.getProperty("childurl");
		if(childurl != null) {
		    return childurl;
		}
		return "";
	}



}
