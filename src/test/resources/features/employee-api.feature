Feature: Employee API
  Validate the employee lookup endpoint.

  Scenario: Fetch an existing employee by id
    When I request employee with id 1
    Then the response status should be 200
    And the employee id should be 1
    And the employee name should be "Alice"

  Scenario: Fetch a missing employee by id
    When I request employee with id 999
    Then the response status should be 404
