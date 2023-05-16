Feature: Verify login feature is working

  Scenario: Login Success
    #@Before
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in
    #@After
