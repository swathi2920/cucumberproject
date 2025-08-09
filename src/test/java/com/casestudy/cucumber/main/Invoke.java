/** DO NOT CHANGE THIS CLASS. THIS CLASS IS FOR REFERENCE ONLY  **/

package com.casestudy.cucumber.main;

import java.util.List;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Invoke {   // DO NOT change the class name
	
	public void checkAgent() {            // DO NOT change the method signature
	    //Invoke the test using TestNG ONLY HERE.
    	try {
    		TestNG testng = new TestNG();
    		List<String> suites = Lists.newArrayList();
    		String workingDir = System.getProperty("user.dir");
    		System.out.println("user.dir "+ workingDir);
    		suites.add(workingDir + "/testng.xml");
    		
    		testng.setTestSuites(suites);
    		testng.run();
		} catch (Exception e) {	 	  	  		 	     	     	      	 	
			//e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    Invoke iv=new Invoke();
	    iv.checkAgent();
	}
}