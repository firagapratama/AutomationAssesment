@All
  Feature: Login

    @Login
    Scenario: Login
      Given User is on login page
      When User fill username and password
      And User click login button
      And User verify login result
      And User click profile menu
      Then User click logout button