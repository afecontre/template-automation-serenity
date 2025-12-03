package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage extends PageObject {

    public static final Target TITLE =
            Target.the("título de Products")
                    .locatedBy("//span[@class='title' and text()='Products']");

    // Botón "Add to cart" del producto Sauce Labs Backpack
    public static final Target ADD_BACKPACK =
            Target.the("botón Add to cart de Sauce Labs Backpack")
                    .locatedBy("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button");

    // Burbuja del carrito (badge con el número de productos)
    public static final Target CART_BADGE =
            Target.the("badge del carrito")
                    .locatedBy(".shopping_cart_link .shopping_cart_badge");
}
