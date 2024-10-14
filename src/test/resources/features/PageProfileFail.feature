Feature: Page Profile Fail
@PageProfileFail
  Scenario Outline: Rellenar el perfil médico con datos inválidos
    Given el usuario accede a la URL "<url>"
    When el usuario completa el campo Licencia Médica con "<licenciaMedica>"
    And el usuario completa el campo Años de Experiencia con "<anosExperiencia>"
    And el usuario completa el campo Expiración Licencia Médica con "<expiracionLicencia>"
    And el usuario completa el campo Resumen Profesional con "<resumenProfesional>"
    And el usuario hace clic en el botón Guardar
    Then se muestra un mensaje de error indicando "<mensajeError>"

    Examples:
      | url                                                                            | licenciaMedica | anosExperiencia | expiracionLicencia | resumenProfesional                     | mensajeError   |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=profile | 12             | 5               | 12102025           | Médico con experiencia en emergencias. | Algo salio mal |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=profile | 78             | 3               | 12032028           | Cirujano con especialización.          | Algo salio mal |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=profile | 12             | 1               | 12042035           | Ninguna experiencia.                   | Algo salio mal |
