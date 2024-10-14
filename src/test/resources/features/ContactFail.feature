Feature: Fallo al rellenar el formulario de contacto

  Scenario Outline: Completar el formulario de contacto con datos inválidos
    Given el usuario accede a la URLL "<url>"
    When el usuario completa el campo Correo con "<correo>"
    And el usuario completa el campo Celular con "<celular>"
    And el usuario completa el campo País con "<pais>"
    And el usuario completa el campo Ciudad con "<ciudad>"
    And el usuario completa el campo Comuna con "<comuna>"
    And el usuario hace clic en el botónn Guardar
    Then se muestra un mensaje de error indicando1 "<mensajeError>"

    Examples:
      | url                                                                            | correo              | celular   | pais  | ciudad     | comuna          | mensajeError   |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=contact | invalid@example.com | 123456789 | Chile | Santiago   | Santiago Centro | Algo salio mal |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=contact | jose@gmail.com      | 987654321 | Chile | Valparaíso | providencia     | Algo salio mal |
      | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc?page=contact | juan@example.com    | 949017709 | Chile | Concepción | vitacura        | Algo salio mal |
