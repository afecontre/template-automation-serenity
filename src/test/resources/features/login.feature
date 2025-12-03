Feature: Login en SauceDemo

  Scenario: Login exitoso con usuario estándar
    Given que Andres abre la página de SauceDemo
    When ingresa las credenciales válidas
    Then debería visualizar el título Products
