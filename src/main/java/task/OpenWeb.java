package task;


import interactions.Highlight;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import ui.WelcomePage;

public class OpenWeb implements Task {

    private final String baseUrl;

    public OpenWeb() {
        // Crea el objeto de configuración leyendo serenity.conf + system properties
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        this.baseUrl = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty("webdriver.base.url");
    }

    public static Performable theHomePage() {
        return Tasks.instrumented(OpenWeb.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Highlight.element(WelcomePage.TITLE),
                Open.url(baseUrl)
        );
    }
}
