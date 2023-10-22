Feature: Login Valid Test
#  Scenario: Login With Invalid Username And Password Test
#    Given User enter url login page
#    When User input invalid username
#    And User input invalid password
#    And User click button login
#    Then User get user greeting text
#
  Scenario: Login With Password Invalid Test
    Given User enter url login page
    When User input valid username
    And User input invalid password
    And User click button login
    Then User get user greeting text

  Scenario: Login valid Test
    Given User enter url login page
    When User input valid username
    And User input valid password
    And User click button login
    Then User get user greeting text