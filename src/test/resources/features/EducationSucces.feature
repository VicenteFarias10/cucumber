Feature: Información Educativa

  Scenario Outline: Llenar información educativa y verificar mensaje de éxito
    Given que tengo acceso a la URL válida "<url>"
    And pongo el correo "<correo>" en el campo de correo
    And pongo la contraseña "<contraseña>" en el campo de contraseña
    And doy clic en el botón de aceptar
    And voy a ver un mensaje de confirmación que indica "<mensajeExito>"
    And que navego a la url "<URL>"
    When hago clic en el btn de educación
    And ingreso la universidad "<Universidad>"
    And ingreso el año de graduación "<AñoGraduacion>"
    And selecciono la especialidad "<Especialidad>" de la lista
    And hago clic en el botón "Guardar"
    Then debería ver el mensaje de éxito "<mensajeExito>"

    Examples:
      | url                                 | correo | contraseña | mensajeExito     | URL                                                                              | Universidad                     | AñoGraduacion | Especialidad |
      | https://app-medica.vercel.app/login | a@a    | abc        | Login Successful | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=education | Universidad de Chile            | 2020          | Neurología   |
