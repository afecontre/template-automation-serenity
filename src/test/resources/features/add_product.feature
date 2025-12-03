Feature: Agregar producto al carrito

  Background:
    Given que Andres abre la página de SauceDemo
    And ingresa las credenciales válidas

  Scenario: Agregar Sauce Labs Backpack al carrito
    When agrega el producto Sauce Labs Backpack al carrito
    Then el carrito debería mostrar 1 producto
