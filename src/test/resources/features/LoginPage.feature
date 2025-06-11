Feature: Login gglobal page

  Background:
    Given User goes to start url "https://staging-client-wms.g-global.io/login"

  Scenario: Go to start url
    Then User is on start url "G-Global G-WMS"
