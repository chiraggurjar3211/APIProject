@tag
Feature: Title of your feature
  I want to use this template for my feature file
	
	##Hello Added Comment line this feature 
	## File to check 
	##Hello Added Comment line this feature 
	## File to check 
	##Hello Added Comment line this feature 
	## File to check 
	##Hello Added Comment line this feature 
	## File to check 
  @tag1
  Scenario: Title of your scenario
    Given Add place Payload
    When User call "AddPlaceAPI" with "POST" http request
    Then API call is sucess with status code 200
    And "scope" response body is "APP"
	
