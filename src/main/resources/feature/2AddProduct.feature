Feature: Add Product Valid Test
  Scenario: Add Product To Cart
    Given User search product
    When User click product
    And User scroll down web page
    And User choose color
    And User choose size
    Then User get text
