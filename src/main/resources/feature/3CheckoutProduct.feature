Feature: Checkout Product Valid Test

  Scenario: Invalid Checkout Product On Cart
    Given User enter url cart
    When User scroll down web page
    And User click proceed button
    And User scroll down web page
    And User enter first name
    And User select region
    And User enter street
    And User enter town
    And User scroll down web page
    And User select province
    And User enter postcode
    And User enter phone number
    And User click term agreement
    And User click order button
    Then User get validation text

  Scenario: Invalid Checkout Product On Cart
    Given User enter url cart
    When User scroll down web page
    And User click proceed button
    And User scroll down web page
    And User enter first name
    And User enter last name
    And User select region
    And User enter town
    And User scroll down web page
    And User select province
    And User enter postcode
    And User enter phone number
    And User click term agreement
    And User click order button
    Then User get validation text

  Scenario: Valid Checkout Product On Cart
    Given User enter url cart
    When User scroll down web page
    And User click proceed button
    And User scroll down web page
    And User enter first name
    And User enter last name
    And User select region
    And User enter street
    And User enter town
    And User scroll down web page
    And User select province
    And User enter postcode
    And User enter phone number
    And User click term agreement
    And User click order button
    Then User get validation text
