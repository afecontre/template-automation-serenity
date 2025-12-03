package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import questions.ValidText;
import task.AddProductToCart;
import task.Login;
import task.OpenWeb;
import ui.ProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    @Given("que Andres abre la página de SauceDemo")
    public void que_andres_abre_la_pagina() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenWeb.theHomePage()
        );
    }

    @When("abre la pagina configurada")
    public void abre_la_pagina_configurada() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenWeb.theHomePage()
        );
    }


    @Then("la pagina deberia abrirse correctamente")
    public void la_pagina_deberia_abrirse_correctamente() {
        boolean isValid = OnStage.theActorInTheSpotlight()
                .asksFor(ValidText.isPresent("Swag Labs"));

        assertThat(isValid).isTrue();
    }

    @When("ingresa las credenciales válidas")
    public void ingresa_las_credenciales_validas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials("standard_user", "secret_sauce")
        );
    }
    @Then("debería visualizar el título Products")
    public void deberia_visualizar_el_titulo_products() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProductsPage.TITLE).isDisplayed()
        );
    }

    @When("agrega el producto Sauce Labs Backpack al carrito")
    public void agrega_el_producto_sauce_labs_backpack_al_carrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductToCart.backpack()
        );
    }

    @Then("el carrito debería mostrar {int} producto")
    public void el_carrito_deberia_mostrar_producto(int expectedCount) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProductsPage.CART_BADGE).text()
                        .isEqualTo(String.valueOf(expectedCount))
        );
    }
}
