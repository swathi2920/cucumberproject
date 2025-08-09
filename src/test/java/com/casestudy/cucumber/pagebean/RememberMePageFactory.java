package com.casestudy.cucumber.pagebean;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RememberMePageFactory {    // DO NOT CHANGE THE CLASS NAME
	
	// Use the below declared variable 
	public WebDriver driver;

    //Constructors are already given. 
    //If required, you can add more code into it but do NOT remove the existing code.
    public RememberMePageFactory(){}
    
	public RememberMePageFactory(WebDriver driver) { 
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	// Implement code here
	
	//click remember me checkbox	
	@FindBy(xpath="/html/body/div/div/div/div/div/div[4]/label/span[2]/input")
	public WebElement rememberMeElmt;
	
	// Implement code here
	
	public void clickRememberMeCheckbox() {
		rememberMeElmt.click();
	}
	
	public Alert handleAlertRemBox(String alertbtn) {  
	    Alert alert = null;
	    try{	 	  	  		 	     	     	      	 	
    		alert = driver.switchTo().alert();
    		if(alertbtn.contains("ok")){
    			driver.switchTo().alert().accept();
    		}else {
    			driver.switchTo().alert().dismiss();
    		}
	    }catch(Exception e){
	        
	    }
	    
	    return alert;
	}
		
	public String checkBoxStatus() {
		if(rememberMeElmt.isSelected()){
			return "Checked";
		}else {
			return "UnChecked";
		}
	}
	
}
