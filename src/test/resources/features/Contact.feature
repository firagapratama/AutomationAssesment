@All
  Feature: Contact
    @Contact
    Scenario: Contact
      Given User is on contact details page
      And User fill contact form
      And User click save contact button
      Then User verify contact result