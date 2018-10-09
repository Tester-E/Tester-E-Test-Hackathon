Feature: Search the properties and book your favorite

  Scenario: Search and Book
    When I go to "https://www.agoda.com/"

    And I sign in "burak.boluk@hotmail.com" "12345678"
    And I enter city "Paris"
    And I choose dates "" ""
    And I choose guest and room
    And I click search

    And I change currency
    And I set price to max "166"
    And I select rating
    And I select location
    And I choose "Family/child friendly"
    And I choose "Free cancellation"
    And I choose "Non-smoking"
    And I sort the properties by "Lowest price first"
    And I select the property
    And I enter card info "Visa / MasterCard / JCB / Amex" "5578292851390447" "Hazal Gunduz" "1022" "006"

    And I cancel room "Paris"
