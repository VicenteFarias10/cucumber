Feature: Pruebas de inicio de sesión
  @LoginFail
  Scenario Outline: Intento de inicio de sesión con credenciales inválidas
    Given que puedo acceder a la URL "<url>"
    When hacemos clic en el botón de login
    And ingresa el Correo "<correo>" en el campo de Correo
    And ingresa la contraseña "<contraseña>" en el campo de Contraseña
    And hacemos clic en el botón de iniciar sesión
    Then debería ver un mensaje de error indicando "<mensajeError>"

    Examples:
      | url                           | correo              | contraseña    | mensajeError        |
      | https://app-medica.vercel.app | invalid@example.com | wrongpassword | Invalid credentials |
      | https://app-medica.vercel.app | another@example.com | wrongpassword | Invalid credentials |
      | https://app-medica.vercel.app | test@example.com    | wrongpassword | Invalid credentials |
