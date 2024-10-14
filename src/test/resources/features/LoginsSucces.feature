Feature: Pruebas de inicio de sesión
  @LoginExitoso
  Scenario Outline: Intento de inicio de sesión con credenciales válidas
    Given que puedo acceder a la URL valida "<url>"
    When hacemos clic en el botón de login valido
    And ingresa el Correo "<correo>" en el campo de Correo valido
    And ingresa la contraseña "<contraseña>" en el campo de Contraseña valida
    And hacemos clic en el botón de iniciar sesión valido
    Then debería ver un mensaje de éxito indicando "<mensajeExito>"

    Examples:
      | url                           | correo                    | contraseña              | mensajeExito     |
      | https://app-medica.vercel.app | vi.fariasr@duocuc.cl      | vichofariasJalvarez2001 | Login Successful |
      | https://app-medica.vercel.app | vicentefariasr1@gmail.com | 123                     | Login Successful |
      | https://app-medica.vercel.app | v.fariasrivara@gmail.com  | 1234                    | Login Successful |
