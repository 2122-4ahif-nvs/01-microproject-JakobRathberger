Feature: Poll get endpoint.
  An user of the endpoint is able to get a Poll

  Background:
    * url baseUrl
    * header Authorization = call read('basic-auth.js') { username: 'scott', password: 'jb0ss' }

  Scenario: Get a poll
    Given path 'api/poll/id/1'
    When method GET
    Then status 200
    And match response == {"description":"Meeting for Project1","id":1,"name":"Meeting"}

  Scenario: Create a poll
    Given path 'api/poll'
    And request { "name": "testPoll", "description": "testDesc" }
    When method POST
    Then status 201

  Scenario: Get created poll
    Given path 'api/poll/id/6'
    When method GET
    Then status 200
    And match response == {"description":"testDesc","id":6,"name":"testPoll"}

  Scenario: Update poll
    Given path 'api/poll'
    And request { "id": "6", "name": "testPollEdit", "description": "testDescEdit" }
    When method PUT
    Then status 200
    And match response == {"description":"testDescEdit","id":6,"name":"testPollEdit"}

  Scenario: Get updated poll
    Given path 'api/poll/id/6'
    When method GET
    Then status 200
    And match response == {"description":"testDescEdit","id":6,"name":"testPollEdit"}
