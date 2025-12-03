package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void setTheStage(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Andres");
    }
}
