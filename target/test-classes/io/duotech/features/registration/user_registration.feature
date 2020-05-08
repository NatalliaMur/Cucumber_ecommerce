Feature: User registration

Background: Given I am on a homepage 
   
    

    Scenario Outline: Verify multiple user registration
    Given I am on a homepage 
    When I click on Sign in
    #And I enter valid "<email>" and click Create Account
    #Line under this comment will create new email for registration and column with email in Examples will not use
    And I enter valid email and click Create Account
    And I should be able to pass the following data and click on register and see the name
     	|First Name    |Last Name     |Address   |Password|City   |Zip   |Phone   |
     	|<first name>  |<last name>   |<address >|dt12345 |<city> |<zip> |<phone> |
        	
    	Examples:
    	|email 											  |first name |last name |address              |city             |zip   | phone              |
    	|rdugget01@redcross.org       |Jilleen    |Dugget    |35288 Mitchell Street|Tariport         |33447 |1-095-694-2015 |
			|gdaniele11@google.com.au     |Ruddy		  |Daniele   |2949 Novick Avenue   |Lake Jessie      |41651 |382.246.5411   |
			|dmanicomb21@timesonline.co.uk|Gwendolen  |Manicomb  |5321 Browning Parkway|North Cameronland|31968 |155-008-2419   |
			|lcoulston31@shinystat.com    |Ddene	    |Coulston  |642 West Street      |East Kirsten     |10830 |1-915-229-7662 |
			|hpaddemore41@cbsnews.com     |Lynett	    |Paddemore |568 Fair Oaks Avenue |Chimouth         |35994 |1-342-610-9026 |
			|dklossek51@zimbio.com        |Had	      |Klossek   |60 Harbort Way       |East Darrickfort |46836 |042.268.4442   |
			|imillett61@de.vu             |Dionysus	  |Millett   |7545 Birchwood Center|Benbury          |89089 |926.016.0222   |
			|bdorkin71@jalbum.net         |Ingrim     |Dorkin    |17722 Sommers Pass   |Gaylordshire     |56415 |1-641-642-6273 |
			|chargitt81@wordpress.org     |Boycie     |Hargitt   |56749 Bay Lane       |North Royce      |42098 |1-753-214-0772 |
			|mspearett91@bbb.org          |Chico	    |Spearett  |182 Myrtle Lane      |South Bongbury   |23575 |750.474.7218   |
			|hkindlesidea1@e-recht24.de   |Michale	  |Kindleside|3 Dayton Alley       |South Dustin     |75287 |510-482-3066   |
			|rrapinettb1@123-reg.co.uk    |Hashim	    |Rapinett  |8578 Cody Crossing   |Bayerland        |45276 |161.375.3961   |
			|hjerzykc1@fema.gov           |Ralina	    |Jerzyk    |93 Pepper Wood Park  |West Monty       |36804 |1-390-728-9663 |
			|rickelld1@earthlink.net      |Hew	      |Rickell   |35724 Anthes Plaza   |East Keeleyside  |27197 |(984) 800-7907 |
			|jocosgrae1@altervista.org    |Krissie    |O'Cosgra  |56 Mayer Park        |Mohrside         |82727 |(088) 352-7365 |
    	