Feature: Option get endpoint.
  An user of the endpoint is able to get an Option

  Background:
    * url baseUrl

  Scenario: Get an option
    Given path 'api/option/id/1'
    When method GET
    Then status 200
