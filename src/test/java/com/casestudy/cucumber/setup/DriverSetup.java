package com.casestudy.cucumber.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {  // DO NOT CHANGE THE CLASS NAME
    
	public static WebDriver driver;
	public static ConfigFileReader filereader = new ConfigFileReader();
	
	public static WebDriver getDriver() {   // DO NOT CHANGE OR MODIFY THE METHOD SIGNATURE
	    
	    if(driver == null) {
    	    //Get the drivername and driverpath by reading configuration file. 
    	   // System.setProperty(/* get the drivername from config */, /* get the driverpath from config */;
//        	    System.setProperty(filereader.getDriverName(), filereader.getDriverPath());
//
//    	    FirefoxBinary firefoxBinary = new FirefoxBinary();
//            firefoxBinary.addCommandLineOptions("--headless");
//            FirefoxProfile profile=new FirefoxProfile();
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.setBinary(firefoxBinary);
//            firefoxOptions.setProfile(profile);
    	    
    	   // driver = new FirefoxDriver(firefoxOptions);	
	    	driver = new ChromeDriver();
	    }
	    
	    return driver;	
	}

}

	 	  	  		 	     	     	      	 	
