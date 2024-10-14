Feature: Rellenar datos de contacto satisfactoriamente
  Scenario Outline: Rellenar con datos validos la seccion de contactos
    Given que puedo acceder a la URL válidaa1 "<url>"
    And ingreso el correo "<correo>" en el campo de correoo
    And ingreso la contraseña "<contraseña>" en el campo de contraseñaa
    And hago clic en el botón de aceptarr
    And debería ver un mensaje de confirmación que indicaa "<mensajeExito>"
    And me redirige hacia la Uri valida de "<urii>"
    When hago click en el btn de contacto
    And  usuario completa el campo Correo con "<correo2>"
    And  usuario completa el campo Celular con "<celular>"
    And  usuario completa el campo País con "<pais>"
    And  usuario completa el campo Ciudad con "<ciudad>"
    And  usuario completa el campo Comuna con "<comuna>"
    And  usuario hace clic en el botónn Guardar
    Then  muestra un mensaje de creado indicando "<mensajeValido>"


    Examples:
      | url                                 | correo        | contraseña | mensajeExito     | urii                                                              | correo2 | celular   | pais  | ciudad   | comuna          | mensajeValido                     |
      | https://app-medica.vercel.app/login | test@test.com | test       | Login Successful | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc |         | 123456789 | Chile | Santiago | Santiago Centro | Contact Info Updated Successfully |