package co.tweek.qa.tasks;

import co.tweek.qa.models.DataManagerTasks;
import co.tweek.qa.usersinterfaces.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateNewTask implements Task{

    private DataManagerTasks data;

    public CreateNewTask(DataManagerTasks data) {
        this.data = data;}

    @Step("create new task")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(MainPage.INPUT),
                Enter.theValue(data.getTitle()).into(MainPage.INPUT),
                Enter.theValue(data.getDetail()).into(MainPage.INPUT).thenHit(Keys.ENTER));
    }
    public static CreateNewTask at(DataManagerTasks data) {
        return instrumented(CreateNewTask.class, data);
    }
}
