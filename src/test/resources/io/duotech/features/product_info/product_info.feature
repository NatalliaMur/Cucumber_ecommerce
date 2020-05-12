
Feature: Product description
    
   #Background: Given I am on a homepage 
 
    Scenario: Verufy product name  
    Given I am on a homepage     
    When I click on Blouse
    Then The product page should also display Blouse
   
   @test
    Scenario: Verufy product name Printed Dress  
    Given I am on a homepage      
    When I click on Printed Dress
    Then The product page should also display Printed Dress
 
 
   Scenario: Verufy default product quantity  
    Given I am on a homepage    
    When I click on Blouse
    Then I land on product page
    And The default quantity for the product should be 1
    
  @smoke 
 Scenario: Verufy product name  
     As a user, I want to be able to login  # Description of the scenario 
    Given I am on a homepage 
    When I click on "Blouse"
    Then The product page should also display "Blouse"
    And The product price should be 27.0
    
    @test1   
   Scenario: Verufy plus and minus button  
       
    Given I am on a homepage
    When I click on Blouse1
    Then I land on product page
    And I click on plus button 10 times
    Then The quantity should be correct
    And I click on minuc button 5 times
    Then The quantity should be correct
    
     
  
    
    
    
    
    

