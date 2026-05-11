Feature: Inicio de sesion en Saucedemo

  @tag1
  Scenario: Login exitoso con credenciales validas
    Given Abro el navegador en la página del login
    When ingreso el usuario "standard_user" y contraseña "secret_sauce"
    And hago click en ingresar 
    Then ingreso a la página de Saucedemo exitosamente