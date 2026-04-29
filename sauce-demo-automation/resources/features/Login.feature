Feature: Invalid Login

Scenario Outline: Invalid Login
  Given user is on login page
  When user enters "<username>" and "<password>"
  Then error should be displayed

Examples:
| username | password |
| user1    | wrong1   |
| user2    | wrong2   |
| user3    | wrong3   |
| user4    | wrong4   |