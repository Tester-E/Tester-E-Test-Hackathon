Feature: Search the properties and book your favorite

  Scenario: Search and Book
    When I go to "https://www.agoda.com/"
    And I enter city "Paris"
    And I choose dates "" ""
    And I choose guest and room
    And I click search

    And I change currency
    And I set price to max "166"
    And I select rating
    And I choose "Family Friendly"
    And I choose "Free Cancellation"
    And I choose "Non-Smoking"
    And I click on neihborhoods