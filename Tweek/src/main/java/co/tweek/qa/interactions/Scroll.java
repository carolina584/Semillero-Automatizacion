package co.tweek.qa.interactions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Scroll implements Interaction {

    private final Target target;

    public Scroll(Target target) {
        this.target = target;
    }

    public static Scroll the(Target target) {
        return new Scroll(target);
    }

    @Step("validate manager task question")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return null;
    }
    public static Scroll in(PageObject page) {
        return instrumented(Scroll.class);
    }
}