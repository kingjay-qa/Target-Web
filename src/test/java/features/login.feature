#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login Feature

Background:
Given I landed on login page 

  Scenario: Validate valid login
    When I entered valid username
    When I entered valid password
    And clicked on login button
    Then I shoulld be taken to homepage
    
    Scenario: Validate in-valid login
    When I entered invalid username
    When I entered invalid password
    And clicked on login button
    Then I should be seeing an error message

  #Scenario Outline: Login to the app
    #Given I want to go to "<url>"
    #When I enter "<username>" and "<password>"
    #Then I click on the login button
#
    #Examples: 
      #| url  | username | password  |
      #| https://login.salesforce.com |     deanjay  | Passwording	|
      #| https://login.salesforce.com |     kingSodi | Autommated  |
