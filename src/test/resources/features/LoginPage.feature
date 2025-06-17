Feature: Login G-Global page

  Background: G-Global site is available
    Given user goes to the start url "https://staging-client-wms.g-global.io/login"

  Scenario: Successful login with valid credentials and validate user can access the site
    Given user writes an existing email into input
    And user writes the correct password into input
    When user clicks on the login button
    Then alert display the message "Success Login"
    And user is now on "https://staging-client-wms.g-global.io/dashboard" page

  Scenario Outline: Trying to login to the site with invalid credentials and validate user invalid login alert is displayed
    Given user writes "<user>" into email input
    And user writes "<password>" into password input
    When user clicks on the login button
    Then alert display the message "Email or password is invalid"
    Examples:
      | user                      | password |
      | joan.hernandez@client.com | password |
      | user@client.com           | password |

  Scenario Outline: Trying to login to the site with invalid parameters and validate invalid parameters alert is displayed
    Given user writes "<user>" into email input
    And user writes "<password>" into password input
    When user clicks on the login button
    Then alert display the message "Parameters validation error"
    Examples:
      | user                  | password    |
      |                       |             |
      |                       | anyPassword |
      | joan.hernandez@client |             |
      | user                  | anyPassword |
      | joan.hernandez@client | anyPassword |
      | any                   | any         |

  Scenario Outline: Trying to fill <field> input with less than 6 chars and validate error message in inputs
    When user writes "<emailText>" into email input
    And user writes "<passText>" into password input
    Then the input "<field>" shows the error message "<errorMsg>" below
    Examples:
      | field    | emailText | passText | errorMsg                     |
      | password |           | ggl      | Please fill up your password |
      | password |           | 1        | Please fill up your password |
      | password |           | globa    | Please fill up your password |
      | email    | ggl       |          | Please fill up your email    |
      | email    | 1         |          | Please fill up your email    |
      | email    | globa     |          | Please fill up your email    |

  Scenario Outline: Fill inputs to show error msg and validate error msg is not visible when criteria is fulfilled in <field> input
    Given user writes "any" into email input
    And user writes "any" into password input
    When user writes "<emailText>" into email input
    And user writes "<passText>" into password input
    Then the input "<field>" error message is not displayed
    Examples:
      | field    | emailText | passText |
      | password |           | global   |
      | email    | gglobal   |          |

  Scenario: User goes to forgot password page validate user return to login page when clicks on cancel button
    Given user clicks on forgot password button
    When user clicks on cancel button in forgot password page
    Then user see the "Welcome" header

  Scenario Outline: User goes to forgot password page and validate send button is disabled on invalid email
    Given user clicks on forgot password button
    When user writes "<email>" in sendEmail input
    Then the send button is not enabled
    Examples:
      | email            |
      |                  |
      | user             |
      | user@@global.com |
      | user@global.com. |

  Scenario Outline: User goes to forgot password page and send valid email and validate link sent msg is displayed
    Given user clicks on forgot password button
    When user writes "<email>" in sendEmail input
    And user clicks on sendEmail button
    Then the "<msg>" "<email>" page is displayed
    Examples:
      | email           | msg                                                      |
      | user@global.com | We have sent a link to reset your password to the email: |

  Scenario: User goes to forgot password page and send valid email validate user returns to login page when clicks to go to Login
    Given user clicks on forgot password button
    When user writes "user@global.com" in sendEmail input
    And user clicks on sendEmail button
    And user clicks on backToLogin button
    Then user see the "Welcome" header
