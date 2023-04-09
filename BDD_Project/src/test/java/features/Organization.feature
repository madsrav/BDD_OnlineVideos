#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

      Feature: Organization Module
      Scenario Outline: As a user I want to create multiple organization and save and verify
      Given  As a user I will launch browser1
      And I will enter url
      And  login page is displayed I will enter Username "admin" and password "admin"  
      And  In home page click on organization
      When organization page is displayed click on create organization
      And In organization page enter organization name "<Organization>" and organization email "<Email>"
      Then click on save
      And Verify that organization is created or not "<Organization>"
      Examples: 
      |Organization|Email|
      |Vkad|www.vkad@gmail.com|
      |Google|www.google@gmail.com|
      |Microsoft|www.microsoft@gmail.com|
      
      
      
      
      