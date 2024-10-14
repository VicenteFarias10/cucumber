Feature: Edición de información personal
@BioDataSuccess
Scenario Outline: Editar información personal con usuario autenticado
Given que puedo acceder a la URL válida1 "<url>"
And ingreso el correo "<correo>" en el campo de correo1
And ingreso la contraseña "<contraseña>" en el campo de contraseña1
And hago clic en el botón de aceptar1
And debería ver un mensaje de confirmación que indica1 "<mensajeExito>"
And me redirige hacia la URI "<uri>"
And lleno el campo Nombre con el valor "<nombre>"
And lleno el campo Apellido con el valor "<apellido>"
And lleno el campo RUT con el valor "<rut>"
And lleno el campo Fecha de Nacimiento con el valor "<fechaNacimiento>"
And elijo "<sexo>" como mi sexo
And hago clic en el botón de guardar1
Then debería ver un mensaje de aceptación "<mensajeAceptado>"

Examples:
  | url                                 | correo | contraseña | mensajeExito     | uri                                                               | nombre  | apellido  | rut        | fechaNacimiento | sexo   | mensajeAceptado                |
  | https://app-medica.vercel.app/login | a@a    | abc        | Login Successful | https://app-medica.vercel.app/onboarding/66d5aed253fd941b1fe8e0dc | Pedrito | Antonales | 12345678-6 | 12102001        | Hombre | Bio Data actualizado con éxito |
