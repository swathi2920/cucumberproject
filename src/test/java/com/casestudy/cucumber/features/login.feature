@Module1
Feature: Login Functionality

Background:
    Given Start firefox for login test
    And navigate to login page

Scenario Outline: To validate user login
	And user enters credentials to login
	|admin|admin#123|
	And user get the captcha generated and enters valid captcha code
	And click on submit button
	Then it should display alert message and click ok

Scenario Outline: To validate invalid username error message
	And user enters invalid username and valid password
	And user get the captcha generated and enters valid captcha code
	And click on submit button
	Then it should display username error message

Scenario Outline: To validate invalid password error message
	And user enters valid username and invalid password
	And user get the captcha generated and enters valid captcha code
	And click on submit button
	Then it should display password error message

Scenario Outline: To validate invalid captcha error message
	And user enters credentials to login
	|admin|admin#123|
	And user enters invalid captcha code
	And click on submit button
	Then it should display captcha error message

Scenario Outline: To validate empty username error message
	And user enters valid password leaving username field empty
	And user get the captcha generated and enters valid captcha code
	And click on submit button
	Then it should display username error message 
	
Scenario Outline: To validate empty password error message
	And user enters valid username leaving password field empty
	And user get the captcha generated and enters valid captcha code
	And click on submit button
	Then it should display password error message
	 
Scenario Outline: To validate empty captcha error message
	And user enters credentials to login
	|admin|admin#123|
	And user leave the captcha field empty
	And click on submit button
	Then it should display captcha error message	 	  	  		    	    		     	 	
