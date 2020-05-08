 
Feature: Login functionality
  I want to use this template for my feature file

Background:
 		Given I am on a homepage
    When I click on Sign in
		
		
    Scenario: Verufy login page title #	Title	  
     As a user, I want to be able to login  # Description of the cenario 
    
    Then The login page title should be Login - My Store
    
     @test   
    Scenario: Verufy login page elements  
    Then I should be able to see email, password and Sign in button
    
   
     Scenario: Verufy positive login   
    And I enter duotech@gmail.com as email, dt123 as rassword, and click login
    Then I should be able to land on welcome page and read Welcome message
    
     
    Scenario: Verufy positive login usingparametrization first   
    And I enter "dt2020@gmail.com" as email, "dt123" as rassword, and click login
    Then I should be able to land on welcome page and read Welcome message
    
    Scenario: Verufy positive login usingparametrization second   
    And I enter "akmaldt@gmail.com" as email, "dt123" as rassword, and click login
    Then I should be able to land on welcome page and read Welcome message
    
     Scenario: Verufy positive login usingparametrization third   
     And I enter "duotech@gmail.com" as email, "dt123" as rassword, and click login
    Then I should be able to land on welcome page and read Welcome message
     
    Scenario: Verufy positive login usingparametrization third   
     And I enter "duogftdgsbs@gmail.com" as email, "dfjfdd" as rassword, and click login
    Then I should be able to land on welcome page and read Welcome message
    
     
   
    	
    	
    
    
    
    
    
    
    
    
    
    
    

