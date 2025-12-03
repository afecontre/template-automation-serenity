package interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class Highlight implements Interaction {

    private final Target locator;

    public Highlight(Target locator) {
        this.locator = locator;
    }

    public static Highlight element(Target locator) {
        return Instrumented.instanceOf(Highlight.class).withProperties(locator);
    }

    @Override
    @Step("{0} resalta el elemento '#{descripcion}'")
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].style.border='3px solid red'; arguments[0].style.padding='3px';",
                locator.resolveFor(actor)
        );
    }

    public String getDescripcion() {
        return locator.getName();
    }
}
