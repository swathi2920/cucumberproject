package com.casestudy.cucumber.definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.casestudy.cucumber.pagebean.RememberMePageFactory;
import com.casestudy.cucumber.setup.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RememberMeTest {   // DO NOT CHANGE THE CLASS NAME

    // Use the below declared variables
	public static WebDriver driver;
	public static RememberMePageFactory rememberpf;
	
    // CREATE THE REQUIRED STEP DEFINITIONS NEEDED FOR THE SCENARIOS in 'rememberme.feature'

    @Given("Start firefox for rememberme test")
	public void Start_firefox_for_registration_test() {
	    driver= DriverSetup.getDriver();
	    rememberpf = new RememberMePageFactory(driver);
	}
    
    @And("navigate to login page for checkbox validation")
	public void navigate_to_login_page_for_checkbox_validation() {
		ConfigFileReader fileReader = new ConfigFileReader();
        driver.get(fileReader.getApplicationUrl());
	}
		
	@When("click on the remember me check box")
	public void click_on_the_remember_me_check_box() {	 	  	  		 	     	     	      	 	
	    rememberpf.clickRememberMeCheckbox();
	}
	
	@Then("it should display remember me alert message and click ok")
	public void it_should_display_remember_me_alert_message_and_click_ok() {
	    rememberpf.handleAlertRemBox("ok");
	}
	
	@Then("it should display remember me alert message and click cancel")
	public void it_should_display_remember_me_alert_message_and_click_cancel() {
	    rememberpf.handleAlertRemBox("cancel");
	}
			
	@Then("check box will show as {string}")
	public void check_box_will_show_as(String value) {
	    String status = rememberpf.checkBoxStatus();
	}
	
}
