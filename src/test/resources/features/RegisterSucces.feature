Feature: Pruebas de registro
  @RegisterSucces
  Scenario Outline: Intento de registro con datos válidos
    Given que puedo acceder a la URL de registro "<url>"
    When ingreso el Nombre Completo "<nombre>"
    And ingreso el Correo Electrónico "<correo>"
    And ingreso el Número de Celular "<celular>"
    And ingreso la Contraseña "<contraseña>"
    And hago clic en el botón de registrarme
    Then debería ver un mensaje de éxito indicando "<mensajeExito>"

    Examples:
      | url                                    | nombre                | correo                        | celular   | contraseña            | mensajeExito                 |
      | https://app-medica.vercel.app/register | Vicente Farias Rivera | vicente21far2iasr2@gma2il.com | 987654321 | ContraseñaSegura2024! | Usuario creado correctamente |
      | https://app-medica.vercel.app/register | María Gómez Rodríguez | mariago2m1ez@gmail.com        | 912345678 | PasswordSeguro1234    | Usuario creado correctamente |
      | https://app-medica.vercel.app/register | Carlos Ruiz Paredes   | carlosru2i12z@gmail2.com      | 987654123 | SeguroPass5678        | Usuario creado correctamente |
