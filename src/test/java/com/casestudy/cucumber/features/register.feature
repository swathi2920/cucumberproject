@Module2
Feature: Register Functionality

Background:
	Given Start firefox for registration test


Scenario: To validate user registration form
	And navigate to login page to open registration form
	And user clicks Register here link in the login page
	Then switch to child window
	Then wait for ten seconds
	And user enters the valid credentials for registration
	|admin|admin#123|admin@test.com|
	And click on registration submit button
	Then it should display registration message

Scenario: To validate registration form with empty username
	And navigate to child url page for registration
	And user enters the password and email leaving username field empty
	And click on registration submit button
	Then it should display empty username error message 

Scenario: To validate registration form with empty password
	And navigate to child url page for registration
	And user enters the username and email leaving password field empty
	And click on registration submit button
	Then it should display empty password error message
	
Scenario: To validate registration form with empty email
	And navigate to child url page for registration
	And user enters the username and password leaving email field empty
	And click on registration submit button
	Then it should display empty email error message	 	  	  		 	     	     	      	 	
