@All
  Feature: Personal
    @Personal
    Scenario: Personal
      Given User is on my info page
      And User click personal details
      And User fill personal form
      And User click save personal button
      Then User verify personal result