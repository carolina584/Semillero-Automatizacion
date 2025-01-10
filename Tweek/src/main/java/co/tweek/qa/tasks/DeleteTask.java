package co.tweek.qa.tasks;

import co.tweek.qa.exceptions.ManagerTask;
import co.tweek.qa.usersinterfaces.Detail;
import co.tweek.qa.usersinterfaces.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteTask implements Task {

    @Step("delete task")
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(MainPage.INPUT),
                    Click.on(Detail.DELETE_BUTTON));
        } catch (Exception e) {
            throw new ManagerTask(ManagerTask.MESSAGE_EXCEPTION_ELEMENT, e);
        }

    }
    public static DeleteTask at() {
        return instrumented(DeleteTask.class);
    }
}
