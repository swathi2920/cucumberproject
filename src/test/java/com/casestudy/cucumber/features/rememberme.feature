@Module3
Feature: Rememberme Functionality

Background:
    Given Start firefox for rememberme test
    And navigate to login page for checkbox validation

Scenario: To validate remember me checkbox checked
	When click on the remember me check box	
	Then it should display remember me alert message and click ok
	Then check box will show as 'Checked'
		
Scenario: To validate remember me checkbox unchecked
	When click on the remember me check box	
	Then it should display remember me alert message and click cancel
	Then check box will show as 'UnChecked'