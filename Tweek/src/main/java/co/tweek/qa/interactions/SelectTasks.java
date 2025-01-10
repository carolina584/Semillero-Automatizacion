package co.tweek.qa.interactions;

import co.tweek.qa.exceptions.ManagerTask;
import co.tweek.qa.usersinterfaces.MainPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import java.util.List;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectTasks implements Interaction {

    public static Actor user = Actor.named("Carolina");

    public static List<WebElementFacade> getElementListTasks() {
        return MainPage.LIST_TASKS.resolveAllFor(user);
    }

    @Step("select tasks")
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            List<WebElementFacade> tasks = getElementListTasks();
            for (WebElement elementTasks : tasks) {
                actor.attemptsTo(Click.on(MainPage.INPUT));
            }
        } catch (Exception e) {
            throw new ManagerTask(ManagerTask.MESSAGE_EXCEPTION_ELEMENT, e);
        }
    }
    public static SelectTasks in() {
        return instrumented(SelectTasks.class);
    }}
