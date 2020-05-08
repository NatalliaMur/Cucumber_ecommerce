Feature: Verufy user information with database

   @db
   Scenario Outline: Verufy user information  
       
    Given I am on a homepage
    #And I have connected to the database
    When I click on Sign in
    And I enter "<email>" as email, "dt12345" as rassword, and click login
    And I click on My Address book
    Then user info related to the email "<email>" should match the info in the database
    
    Examples:
        |email         								 |
        |rdugget0@redcross.org         | 
        |gdaniele1@google.com.au       | 
        |dmanicomb2@timesonline.co.uk  | 
        |lcoulston3@shinystat.com      | 
        |hpaddemore4@cbsnews.com       | 
        |dklossek5@zimbio.com          | 
        |imillett6@de.vu               |
        |chargitt8@wordpress.org       |
        |mspearett9@bbb.org            |
        |hkindlesidea@e-recht24.de     | 
        |rrapinettb@123-reg.co.uk      |
        |hjerzykc@fema.gov             |
        |krickelld@earthlink.net       |
        |jocosgrae@altervista.org      | 