package com.casestudy.cucumber.pagebean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RegisterPageFactory {  // DO NOT CHANGE THE CLASS NAME

	// Use the below declared variable 
	public WebDriver driver;
    public WebElement element;
    static String childWinTitle;
    //Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
    public RegisterPageFactory(){}
    
	public RegisterPageFactory(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Implement code here 
	
    //click the registration form link	
	@FindBy(xpath="/html/body/div/div/div/div/div/div[5]/a")
	public WebElement registerHereElmt;
		
	//enter the username	
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[1]/input")
	public WebElement usernameRegElmt;
	
	//enter the password	
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[2]/input")
	public WebElement passwordRegElmt;
	
		
	//enter the email
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[3]/input")
	public WebElement emailRegElmt;
	
	//click on submit button for registration
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[4]/input")
	public WebElement submitbtnRegElmt;
	
	
	//registration message 
	@FindBy(xpath="/html/body/div/div/div/div/div[2]/h3")
	public WebElement registrationMsgElmt;	
		
	//error message for empty username
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[1]/div")
	public WebElement usernameErrRegElmt;	

	//error message for empty password
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[2]/div")
	public WebElement passwordErrRegElmt;
	
	//error message for empty email
	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[3]/div")
	public WebElement emailErrRegElmt;
	
	
	public void clickRegistrationForm() {		
		registerHereElmt.click();
	}
	
		
	public void setRegUsername(String uname) {
		usernameRegElmt.sendKeys(uname);
	}
	
	public void setRegPassword(String passwd) {
		passwordRegElmt.sendKeys(passwd);
	}
	
	public void setRegEmail(String email) {
		emailRegElmt.sendKeys(email);
	}
		
		
	public void clickRegLoginBtn() {		
		submitbtnRegElmt.click();
	}
	
	public String getRegistrationMsg() {		
		return registrationMsgElmt.getText();
	}
	
	
	public String getRegUsernameError() {		
		return usernameErrRegElmt.getText();
	}	 	  	  		 	     	     	      	 	
	
	public String getRegPasswordError() {		
		return passwordErrRegElmt.getText();
	}
	
	public String getRegEmailError() {		
		return emailErrRegElmt.getText();
	}
	
	public String getChildWindow() {
	    // Click the href 'Register here' link. Find the child window's handle.
        //Hint: WAIT for child page to load and find the child window handle.
        //Get the page title and store it in 'childWinTitle' and return it.
        
	    String MainWindow = driver.getWindowHandle();

	    // To handle all new opened window
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    
	    while (i1.hasNext()) {	 	  	  		 	     	     	      	 	
          String ChildWindow = i1.next();
          if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
              driver.switchTo().window(ChildWindow);
              childWinTitle=driver.getTitle();
              //System.out.println("Child window closed");
           }
       }
       
       return childWinTitle;
	}
    
    
}
