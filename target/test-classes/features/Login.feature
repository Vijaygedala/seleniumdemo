Feature: Application Login
Scenario: Login With valid credentials
Given open any browser
And navigate to login page
When user enters username as "vijay2@gmail.com" and password as "123456" in ti the fields
And user clicks on login button
Then verify user is able to login sucessfully or not