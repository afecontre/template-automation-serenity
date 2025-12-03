package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target USERNAME =
            Target.the("campo usuario")
                    .locatedBy("#user-name");

    public static final Target PASSWORD =
            Target.the("campo contraseña")
                    .locatedBy("#password");

    public static final Target LOGIN_BUTTON =
            Target.the("botón de login")
                    .locatedBy("#login-button");
}
