package com.casestudy.cucumber.pagebean;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory { // DO NOT CHANGE THE CLASS NAME
	
	// Use the below declared variable 
	public WebDriver driver;

    //Constructors are already given. 
    //If required, you can add more code into it but do NOT remove the existing code.
    public LoginPageFactory(){}
    
	public LoginPageFactory(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Implement code here
	
	//enter the username	
	@FindBy(xpath="/html/body/div/div/div/div/div/div[1]/input")
	public WebElement usernameElmt;
	
	//enter the password	
	@FindBy(xpath="/html/body/div/div/div/div/div/div[2]/input")
	public WebElement passwordElmt;
	
	//get the generated captcha code
	@FindBy(xpath="/html/body/div/div/div/div/div/div[3]/div[1]/div[2]")
	public WebElement getcaptchaElmt;
		
	//enter the captcha	code
	@FindBy(xpath="/html/body/div/div/div/div/div/div[3]/input")
	public WebElement captchaElmt;
	
	//click on submit button for login
	@FindBy(xpath="/html/body/div/div/div/div/div/div[4]/input")
	public WebElement submitbtnElmt;
	
	//error message for invalid or empty username
	@FindBy(xpath="/html/body/div/div/div/div/div/div[1]/div")
	public WebElement usernameErrElmt;	

	//error message for invalid or empty password
	@FindBy(xpath="/html/body/div/div/div/div/div/div[2]/div")
	public WebElement passwordErrElmt;
	
	//error message for invalid or empty captcha
	@FindBy(xpath="/html/body/div/div/div/div/div/div[3]/div[2]")
	public WebElement captchaErrElmt;
	
	
	public void setUsername(String uname) {
		usernameElmt.sendKeys(uname);
	}
	
	public void setPassword(String passwd) {
		passwordElmt.sendKeys(passwd);
	}
	
	public void setCaptcha(String captcha) {
		captchaElmt.sendKeys(captcha);
	}
		
	public String getCaptchaCode() {		
		return getcaptchaElmt.getText();
	}
	
	public void clickLoginBtn() {		
		submitbtnElmt.click();
	}
	
	public String getUsernameError() {		
		return usernameErrElmt.getText();
	}
	
	public String getPasswordError() {		
		return passwordErrElmt.getText();
	}
	
	public String getCaptchaError() {	 	  	  		 	     	     	      	 	
		return captchaErrElmt.getText();
	}
	
	public Alert handleAlertBox() {
    	Alert alert = driver.switchTo().alert();		
    	alert.accept();	
	    return alert;	
	}
	
	
}
