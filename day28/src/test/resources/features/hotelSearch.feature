Feature: Hotel Search

@Smoke
Scenario: Validate Hotel Search

Given user opens hotel booking website
When user enters destination "Dubai"
And select Nationality
And user clicks on search button
Then validate hotel search results
And validate available hotels count