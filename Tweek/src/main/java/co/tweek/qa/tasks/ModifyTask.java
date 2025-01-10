package co.tweek.qa.tasks;

import co.tweek.qa.models.DataManagerTasks;
import co.tweek.qa.usersinterfaces.Detail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ModifyTask implements Task {

    private DataManagerTasks data;

    public ModifyTask(DataManagerTasks data) {
        this.data = data;}

    @Step("modify task")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(data.getDetail()).into(Detail.TEXTAREA_BODY),
                Enter.theValue(data.getTitle()).into(Detail.TEXTAREA_TITLE).thenHit(Keys.ENTER),
                Click.on(Detail.CHECK_STATUS));
    }

    public static ModifyTask inFile(DataManagerTasks data) {
        return instrumented(ModifyTask.class, data);
    }
}