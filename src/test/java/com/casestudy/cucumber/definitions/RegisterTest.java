package com.casestudy.cucumber.definitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.casestudy.cucumber.pagebean.RegisterPageFactory;
import com.casestudy.cucumber.setup.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTable.TableConverter;

public class RegisterTest { // DO NOT CHANGE THE CLASS NAME

    // Use the below declared variables
	public static WebDriver driver;	
	public static RegisterPageFactory registerpf;
	
	
	// CREATE THE REQUIRED STEP DEFINITIONS NEEDED FOR THE SCENARIOS in 'register.feature'
	
	@Given("Start firefox for registration test")
	public void Start_firefox_for_registration_test() {
	    driver= DriverSetup.getDriver();
	    registerpf = new RegisterPageFactory(driver);
	}	 	  	  		 	     	     	      	 	
	
	@And("navigate to login page to open registration form")
	public void navigate_to_login_page_to_open_registration_form() {
		ConfigFileReader fileReader = new ConfigFileReader();
        driver.get(fileReader.getApplicationUrl());
	}
	
	@And("user clicks Register here link in the login page")
	public void user_clicks_Register_here_link_in_the_login_page() {
		registerpf.clickRegistrationForm();		
	}
	
	@Then("switch to child window")
	public void switch_to_child_window() {
		registerpf.getChildWindow();
	}
	
	@Then("wait for ten seconds")
	public void wait_for_ten_seconds() {		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@And("user enters the valid credentials for registration")
	public void user_enters_the_valid_credentials_for_registration(DataTable usercredentials) {
//		List<String> data=usercredentials.asList();
//		List<String> data = usercredentials.asList(String.class);
		List<List<String>> data = usercredentials.asLists(String.class);
		
//		List<Object> data = usercredentials.getTableConverter().toList(usercredentials, String.class);
	
		System.out.println("################## RegisterTest Credentials ##############");
		System.out.println(data.get(0).get(0));
		System.out.println(data.get(0).get(1));
		System.out.println(data.get(0).get(2));
		
		registerpf.setRegUsername(data.get(0).get(0));
		registerpf.setRegPassword(data.get(0).get(1));
		registerpf.setRegEmail(data.get(0).get(2));
	}
	
	@And("click on registration submit button")
	public void click_on_registration_submit_button() {
		registerpf.clickRegLoginBtn();
	}
	
	@Then("it should display registration message")
	public void it_should_display_registration_message() {	 	  	  		 	     	     	      	 	
		registerpf.getRegistrationMsg();
	}	
	
	@Given("navigate to child url page for registration")
	public void navigate_to_child_url_page_for_registration() {
		ConfigFileReader fileReader = new ConfigFileReader();
        driver.get(fileReader.getApplicationChildUrl());
	}
	
	@And("user enters the password and email leaving username field empty")
	public void user_enters_the_password_and_email_leaving_username_field_empty() {
		registerpf.setRegUsername("");
		registerpf.setRegPassword("admin123");
		registerpf.setRegEmail("test@123.com");
	}
	
	@Then("it should display empty username error message")
	public void it_should_display_empty_username_error_message() {
	    registerpf.getRegUsernameError();
	}
	
	@And("user enters the username and email leaving password field empty")
	public void user_enters_the_username_and_email_leaving_password_field_empty() {
		registerpf.setRegUsername("admin");
		registerpf.setRegPassword("");
		registerpf.setRegEmail("test@123.com");
	}
	
	@Then("it should display empty password error message")
	public void it_should_display_empty_password_error_message() {
	    registerpf.getRegPasswordError();
	}
	
	@And("user enters the username and password leaving email field empty")
	public void user_enters_the_username_and_password_leaving_email_field_empty() {
		registerpf.setRegUsername("admin");
		registerpf.setRegPassword("admin#123");
		registerpf.setRegEmail("");
	}	 	  	  		 	     	     	      	 	
	
	@Then("it should display empty email error message")
	public void it_should_display_empty_email_error_message() {
	    registerpf.getRegEmailError();
	}
	
}
