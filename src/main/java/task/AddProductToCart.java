package task;

import interactions.Highlight;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.ProductsPage;

public class AddProductToCart implements Task {

    public static Performable backpack() {
        return Tasks.instrumented(AddProductToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Highlight.element(ProductsPage.ADD_BACKPACK),
                Click.on(ProductsPage.ADD_BACKPACK)
        );
    }
}
