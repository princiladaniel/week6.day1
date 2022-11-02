Feature: CreateIncident in the ServiceNow Application

Background:
When Enter Username as "admin"
And  Enter Password as "iX-66uY+DwSi"
When Click on Login button
Given Click on All
Given Click Incidents in Filter navigator

Scenario Outline:CreateIncident
When Click on new button
And  Get Incident Number
And Enter the shortDescription <shortDesc>
When Click on submit button
And choose <number> from dropDown
And Get New Incident Number
Then verify Incident created

Examples:
|shortDesc|number|
|'Create via Automation'|'Number'|
|'Create via Manual'|'Short description'|

