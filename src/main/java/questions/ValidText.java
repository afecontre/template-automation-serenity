package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import ui.WelcomePage;

@Subject("el texto esperado está presente en la página")
public class ValidText implements Question<Boolean> {

    private final String expectedText;

    public ValidText(String expectedText) {
        this.expectedText = expectedText;
    }

    public static ValidText isPresent(String text) {
        return new ValidText(text);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return WelcomePage.TITLE.resolveFor(actor).getText().equals(expectedText);
    }
}
