package task;

import interactions.Highlight;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import ui.LoginPage;

public class Login implements Task {

    private final String user;
    private final String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Performable withCredentials(String user, String password) {
        return Tasks.instrumented(Login.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Highlight.element(LoginPage.USERNAME),
                Enter.theValue(user).into(LoginPage.USERNAME),
                Highlight.element(LoginPage.PASSWORD),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Highlight.element(LoginPage.LOGIN_BUTTON),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
