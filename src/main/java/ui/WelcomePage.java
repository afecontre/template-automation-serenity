package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class WelcomePage extends PageObject {
    public static final Target TITLE =
            Target.the("Título Swag Labs")
                    .locatedBy("//div[@class='login_logo' and text()='Swag Labs']");
}
