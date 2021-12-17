Feature: Google Search

  @Smoke
   @enable: true
   Scenario: Sample Test
   Given get '/'
   When search for 'qaf github infostretch'
   Then verify link with partial text 'qaf' is present
  
  @enable: false
  @dataFile = "resources/data/calcdata.txt"  
  Scenario: my first bdd	
    Given click on "clear.btn.loc"
    And click on button "${val1}"
    And click on "${operation}.btn.loc"
    And click on button "${val2}"
    And click on "eq.btn.loc"
    Then verify "res.btn.loc" value is "${expectedResult}"
    
  @enable: false 
  Scenario: scenario_description
    Given get "google.com"
    Then sendKeys "automation + Selenium" into "name=q"
    And submit "name=q"
   