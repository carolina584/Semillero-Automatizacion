package co.tweek.qa.questions;

import co.tweek.qa.usersinterfaces.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class ValidateTitle implements Question<Boolean> {

    @Step("validate title")
    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(MainPage.INPUT).viewedBy(actor).asString().isEmpty();
    }

    public static ValidateTitle in() {
        return new ValidateTitle();
    }
}