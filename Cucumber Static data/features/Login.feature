Feature: Login of LeafTaps
Background:
Given Launch the browser
And Load the 'http://leaftaps.com/opentaps/control/login'
And maximize the browser
Scenario: Tc_001 Login positive flow
Given Enter the username as 'demosalesmanager'
And Enter the password as 'crmsfa'
When click the login button
#Then open home screen

#Scenario: Tc_001 Login negative flow
#Given Enter the password as crmsf
#When click on the login button
#But Error message is diplayed

