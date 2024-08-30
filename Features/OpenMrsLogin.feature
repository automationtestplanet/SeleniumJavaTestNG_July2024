@LoginFeature
Feature: OpenMRS Login feature

  Background: 
    Given Launch OpenMRs Login Page

  @LoginWithValidCredentials @LoginWithValidAndInValidCredentials
  Scenario: Verify Login with valid Credentials
    Given User is on OpenMRs Login Page
    When User logins with Username "ABCD123" and Password "ABCD123"
    And Clicks Login button
    Then Login should successfull

  @LoginWithInValidCredentials @LoginWithValidAndInValidCredentials
  Scenario: Verify Login with invalid Credentials
    Given User is on OpenMRs Login Page
    When User logins with Username "ABCD@123" and Password "ABCD@123"
    And Clicks Login button
    Then Login should fail

  @LoginWithultipleUsers
  Scenario Outline: Verify Login with multiple sets of users "<UserName>" and "<Password>"
    Given User is on OpenMRs Login Page
    When User logins with Username "<UserName>" and Password "<Password>"
    And Clicks Login button
    Then Login should successfull

    Examples: 
      | UserName | Password |
      | ABCD123  | ABCD123  |
      | BCDE123  | BCDE123  |
      | CDEF123  | CDEF123  |

  @LoginWithValidMultipleCredentials
  Scenario: Verify Login with valid Credentials
    Given User is on OpenMRs Login Page
    When User logins with Username and Password
      | UserName | Password |
      | ABCD123  | ABCD123  |
      | BCDE123  | BCDE123  |
      | CDEF123  | CDEF123  |
    And Clicks Login button
    Then Login should successfull
