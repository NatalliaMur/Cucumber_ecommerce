Feature: Login functionality using datatables
  I want to use this template for my feature file

Background:
 		Given I am on a homepage
    When I click on Sign in

 Scenario: Verufy positive login using datatable
    And I enter the following credentials, I should be login
     	|duotech@gmail.com |dt123     |
    	|akmaldt@gmail.com |dt123     |
    	|dt2020@gmail.com  |dt123     |
    	|duotech1@gmail.com|duotech1  |
    	|duotech2@gmail.com|duotech22 |
    	|duotech3@gmail.com|duotech333|
    	
   	
    Scenario: Verufy user registration
    And I enter valid email and click Create Account
    And I should be able to pass the following data and click on register and see the name
     	|First Name |Last Name |Address           |Password|City   |Zip   |Phone      |
     	|Jhon       |Smith     |8133 Leesburg Pike|dt12345 |Vienna |22182 |2024534738 |
    	|Jane       |Doe       |553 Main st       |dt66666 |Vienna |22030 |5714534738 |