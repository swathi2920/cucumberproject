package com.casestudy.cucumber.definitions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.casestudy.cucumber.pagebean.LoginPageFactory;
import com.casestudy.cucumber.setup.*;
import com.casestudy.cucumber.setup.ConfigFileReader;

public class LoginTest {    // DO NOT CHANGE THE CLASS NAME
	
	// Use the below declared variables
    public static WebDriver driver;
	public static LoginPageFactory loginpf;
	
	// CREATE THE REQUIRED STEP DEFINITIONS NEEDED FOR THE SCENARIOS in 'login.feature'
	
	@Given("Start firefox for login test")
	public void Start_firefox_for_login_test() {
	    driver= DriverSetup.getDriver();
	    loginpf=new LoginPageFactory(driver);
	}
	
	@And("navigate to login page")
	public void navigate_to_login_page() {
		ConfigFileReader fileReader = new ConfigFileReader();
        driver.get(fileReader.getApplicationUrl());
	}
	
	@And("user enters credentials to login")
	public void user_enters_credentials_to_login(DataTable usercredentials) {
		loginpf=new LoginPageFactory(driver);
		List<List<String>> data = usercredentials.asLists(String.class);
		loginpf.setUsername(data.get(0).get(0).toString());
	    loginpf.setPassword(data.get(0).get(1).toString());
	}	 	  	  		 	     	     	      	 	
	
	@And("user get the captcha generated and enters valid captcha code")
	public void user_get_the_captcha_generated_and_enters_valid_captcha_code() {
        String capcode = loginpf.getCaptchaCode();
        loginpf.setCaptcha(capcode);
	}
	
	@And("click on submit button")
	public void click_on_submit_button() {
	   loginpf.clickLoginBtn();
	}
	
	@Then("it should display alert message and click ok")
	public void it_should_display_alert_message_and_click_ok() {
	   loginpf.handleAlertBox();
	}	
	
	@And("user enters invalid username and valid password")
	public void user_enters_invalid_username_and_valid_password() {
		loginpf.setUsername("adm");
	    loginpf.setPassword("admin#123");
	}	
	
	@Then("it should display username error message")
	public void it_should_display_username_error_message() {
	    loginpf.getUsernameError();
	}	
	
	@Then("it should display password error message")
	public void it_should_display_password_error_message() {
	    loginpf.getPasswordError();
	}	 	  	  		 	     	     	      	 	
	
	
	
	
	@Then("it should display captcha error message")
	public void it_should_display_captcha_error_message() {
	    loginpf.getCaptchaError();
	}
	
	
	@And("user enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() {
		loginpf.setUsername("admin");
	    loginpf.setPassword("admin#");
	}
	
	@And("user enters invalid captcha code")
	public void user_enters_invalid_captcha_code() {
		loginpf.setCaptcha("123#");
	}
		
	@And("user enters valid password leaving username field empty")
	public void user_enters_valid_password_leaving_username_field_empty() {
		loginpf.setUsername("");
	    loginpf.setPassword("admin#");
	}

	@And("user enters valid username leaving password field empty")
	public void user_enters_valid_username_leaving_password_field_empty() {
		loginpf.setUsername("admin");
	    loginpf.setPassword("");
	}
		
	@And("user leave the captcha field empty")
	public void user_leave_the_captcha_field_empty() {
		loginpf.setCaptcha("");
	}
	//==========
	
}

	
	
	



	


