#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if place is successfully added with AddPlace API

	Given Add Place Payload with "<name>" "<language>" "<address>"
	When User calls "addPlaceAPI" with "post" HTTP request
	Then The API call is success with status code 200
	And "status" code in response body is "OK"
	And "scope" code in response body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	#Then verify "status" code in response body is "OK" using "deletePlaceAPI"
	
	Examples:
	|name|language|address|	
	|PhaniSwe|TH-th|Asok house|
	#|phaniharika|TH-th|narathiwas house|

	@DeletePlace
	Scenario: Verify if delete place functionality is working fine
	
	Given Delete place Payload
	When User calls "deletePlaceAPI" with "delete" HTTP request
	Then The API call is success with status code 200
	And "status" code in response body is "OK"
	
	
	