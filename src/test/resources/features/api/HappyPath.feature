@sample @api_demo
Feature: Create API test scenarios for Get, Post, Put and Delete Http methods using demo webservice

 Scenario: Get the details of employee
    Given I send a request to endpoint using params employee/1
    Then The API should return status 200
    And Response should contains employee name Tiger Nixon

  Scenario: Create an employee using dummy body content
    Given I send a request to endpoint using params create and following body content name salary age
    | name | salary | age|
    | test | 123    | 23 |
    Then The API should return status 200
    And Response should contains employee name test
