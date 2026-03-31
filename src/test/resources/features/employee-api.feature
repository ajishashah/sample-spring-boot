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

  Scenario: Update employee name by id
    When I update employee name for id 2 to "Robert"
    Then the response status should be 200
    And the employee id should be 2
    And the employee name should be "Robert"

  Scenario: Delete an existing employee by id
    When I delete employee with id 1
    Then the response status should be 204
    When I request employee with id 1
    Then the response status should be 404
