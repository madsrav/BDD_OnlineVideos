 Feature: contactmodule
 @End2End
 Scenario: As a user I want to create new contact
 Given I will Launch browser
 And enter the url 
 And when the login page is displayed i will enter username "admin" and password "admin" 
 And click on login
 When home page is displayed click on contact
 And click on create contact button
 And enter contact name contact email and contact phone
 |lname|Email|Phone|
 |sravan|srav@gmail.com|986532589|
 And click on save button
 Then verify contact name and contact email and contact phone
 And close the browser
