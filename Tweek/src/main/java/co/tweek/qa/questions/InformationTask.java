package co.tweek.qa.questions;

import co.tweek.qa.usersinterfaces.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class InformationTask implements Question<String> {

    @Step("validate manager task question")
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MainPage.LIST_TASKS).viewedBy(actor).asString();
    }

    public static InformationTask verify() {
        return new InformationTask();
    }
}