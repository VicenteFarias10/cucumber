Feature: Realizar transferencia entre cuentas

  Scenario: : Realizar transferencia correctamente
    Given al navegar hasta la url "https://demo.testfire.net/"
    When hacemos click en el Sign In link
    And coloca en el campo usuario y en el campo password un valor valido  <NroFila>
    And hacer click sobre el boton Login
    And hacer click en el link Transfer Funds
    And Indicar la cuenta de cargo en From Account  <NroFila>
    And Indica la cuenta beneficiaria  en To Account <NroFila>
    And Indicar monto a transferir  en Amount TO  <NroFila>
    And hacer click en el boton Transfer Money
    Then El mensaje de resultados debe contener un mensaje de ingreso <NroFila>


    Examples:
      | NroFila  |
      | 1        |
      | 2        |
      | 5        |