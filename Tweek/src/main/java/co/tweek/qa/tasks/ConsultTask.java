package co.tweek.qa.tasks;

import co.tweek.qa.exceptions.ManagerTask;
import co.tweek.qa.usersinterfaces.Detail;
import co.tweek.qa.usersinterfaces.MainPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultTask implements Task {

    @Step("consult task")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
                actor.attemptsTo(
                        Click.on(MainPage.INPUT),
                        Click.on(Detail.TEXTAREA_TITLE));
        } catch (Exception e) {
            throw new ManagerTask(ManagerTask.MESSAGE_EXCEPTION_ELEMENT, e);
        }
    }
    public static ConsultTask inFile(PageObject page) {
        return instrumented(ConsultTask.class);
    }
}
