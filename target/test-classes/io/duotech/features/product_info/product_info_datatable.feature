
Feature: Product info verifiction using datatables

Background: Given I am on a homepage 

  #Implementing scenario without using datatable
    
    Scenario: Verify Women subcategories
   
    When I click on Women link
    Then The Tops subcategory should be display
    
     #Implementing scenario using datatable
    
    Scenario: Verify Women subcategories
  
    When I click on Women link
    Then The following subcategories should be display
    |Tops   |
    |Dresses|
    

    Scenario: Verify Dresses page 
  
    When I click on Dresses link
    Then The following subcategories should be displayed
    	|Casual Dresses|
    	|Evening Dresses|
    	|Summer Dresses|
    #	|Winter Dresses|
    
   
    Scenario: Verify colors on Dresses page 
 
    When I click on Dresses link
    Then The following colors should be displayed
    	|Beige |
    	|Black|
    	|Blue|
    	|Yellow |
    	|White|
    	|Orange|
    	|Green|
    	|Pink|
    