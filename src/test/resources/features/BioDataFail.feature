Feature: Rellenar información personal en onboarding con error
  @BioDataFail
  Scenario Outline: Completar datos personales
    Given que puedo ir a la URL de onboarding "<url>"
    When completo el campo Nombre con "<nombre>"
    And completo el campo Apellido con "<apellido>"
    And completo el campo RUT con "<rut>"
    And completo el campo Fecha de Nacimiento con "<fechaNacimiento>"
    And selecciono "<sexo>" como sexo
    And hago clic en el botón de guardar
    Then debería ver un mensaje de error "<mensajeAceptado>"

    Examples:
      | url                                                                             | nombre | apellido | rut        | fechaNacimiento | sexo   | mensajeError                    |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=bio-data | Juan   | Pérez    | 12345678-9 | 12102001        | Hombre | Error al crear perfil de doctor |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=bio-data | Pedro  | Gómez    | 98765432-1 | 12102002        | Hombre | Error al crear perfil de doctor |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=bio-data | Juan   | Torres   | 12345678-9 | 12102003        | Hombre | Error al crear perfil de doctor |
