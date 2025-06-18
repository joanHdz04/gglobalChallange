Feature: Validate Return page scenarios

  Background: G-Global site is available
    Given user goes to the start url "https://staging-client-wms.g-global.io/login"
    And user writes an existing email into input
    And user writes the correct password into input
    And user clicks on the login button
    And user sees success login alert

  Scenario Outline: Return search by RMA input and validate the data returned
    Given user clicks on returns on navigation bar
    When user writes "<RMA>" in RMA number field
    Then the data table displays "<RMA>" in the "<RMAColumn>" column in the <rowNumber> row
    Then the data table displays "<Tracking>" in the "<TrackingColumn>" column in the <rowNumber> row
    Then the data table displays "<Almacen>" in the "<AlmacenColumn>" column in the <rowNumber> row
    Examples:
      | RMA        | RMAColumn         | Tracking   | TrackingColumn    | Almacen               | AlmacenColumn | rowNumber |
      | RMA-000045 | Número de Retorno | tracking1  | Número de Rastreo | G-Global 3PL Pacífico | Almacén       | 1         |
      | RMA000101  | Número de Retorno | 1123456767 | Número de Rastreo | G-Global San Diego    | Almacén       | 1         |

  Scenario Outline: Return search by tracking input and validate the data returned
    Given user clicks on returns on navigation bar
    When user writes "<Tracking>" in tracking field
    Then the data table displays "<Tracking>" in the "<TrackingColumn>" column in the <rowNumber> row
    Then the data table displays "<RMA>" in the "<RMAColumn>" column in the <rowNumber> row
    Then the data table displays "<Almacen>" in the "<AlmacenColumn>" column in the <rowNumber> row
    Examples:
      | RMA        | RMAColumn         | Tracking   | TrackingColumn    | Almacen               | AlmacenColumn | rowNumber |
      | RMA000101  | Número de Retorno | 1123456767 | Número de Rastreo | G-Global San Diego    | Almacén       | 1         |