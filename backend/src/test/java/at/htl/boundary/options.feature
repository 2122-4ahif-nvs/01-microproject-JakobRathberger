Feature: Option get endpoint.
  An user of the endpoint is able to get an Option

  Background:
    * url baseUrl
    * header Authorization = call read('basic-auth.js') { username: 'scott', password: 'jb0ss' }

  Scenario: Get an option
    Given path 'api/option/id/1'
    When method GET
    Then status 200
    And match response == {"endTime":"2022-01-30T14:00:00","id":1,"poll":{"description":"Meeting for Project1","id":1,"name":"Meeting"},"startTime":"2022-01-30T12:00:00"}
