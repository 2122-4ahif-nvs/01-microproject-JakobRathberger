Feature: Poll get endpoint.
  An user of the endpoint is able to get a Poll

  Background:
    * url baseUrl
    * header Authorization = call read('basic-auth.js') { username: 'scott', password: 'jb0ss' }

  Scenario: Get a poll
    Given path 'api/poll/id/1'
    When method GET
    Then status 200
