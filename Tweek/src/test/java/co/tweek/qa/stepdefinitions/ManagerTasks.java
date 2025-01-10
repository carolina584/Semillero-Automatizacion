package co.tweek.qa.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import co.tweek.qa.models.DataManagerTasks;
import co.tweek.qa.questions.InformationTask;
import co.tweek.qa.questions.ValidateTitle;
import co.tweek.qa.tasks.*;
import co.tweek.qa.usersinterfaces.MainPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ManagerTasks {

    @Managed(driver= "chrome")
    private WebDriver hisBrowser;

    private Actor user = Actor.named("Carolina");
    private MainPage page;

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^usuario se encuentra en aplicativo Tweek$")
    public void usuarioSeEncuentraEnAplicativoTweek() {
        user.wasAbleTo(Open.browserOn(page));
        user.attemptsTo(GotoMain.at(page));
    }

    @When("^el usuario ingresa el título (.*) y detalle(.*)$")
    public void elUsuarioIngresaElTituloY(List<DataManagerTasks> data) {
        for (DataManagerTasks reservationData : data) {
            user.attemptsTo(CreateNewTask.at(reservationData));
        }
    }

    @Then("^se visualizan (.*) y descripción (.*) de la tarea$")
    public void seVisualizanYDescripcionDeLaTarea(String title, String description) {
        assertThat(InformationTask.verify()).toString();
    }

    @When("^el usuario busca la tarea(.*)$")
    public void elUsuarioBuscaLaTareaConTitulo() {
            user.attemptsTo(ConsultTask.inFile(page));
    }

    @Then("^visualizan el título (.*) y la descripción (.*) de la tarea$")
    public void seVisualizanElTituloYLaDescripcionDeLaTarea(String title, String description) {
        user.should(seeThat(InformationTask.verify(),  containsString(title)));
        user.should(seeThat(InformationTask.verify(),  containsString(description)));
    }

    @When("^el usuario modifica el (.*) y (.*)$")
    public void elUsuarioModificaElY(List<DataManagerTasks> data) {
        for (DataManagerTasks reservationData : data) {
            user.attemptsTo(ModifyTask.inFile(reservationData));
        }
    }

    @Then("^se visualiza la informacion(.*)$")
    public void seVisualizanElTituloYLaDescripcion(String info)  {
        user.should(seeThat(InformationTask.verify(),  containsString(info)));
    }

    @When("^el usuario selecciona y elimina la tarea$")
    public void elUsuarioIntentaEliminarLaTareaCon() {
        user.attemptsTo(DeleteTask.at());
    }

    @Then("^la tarea es eliminada$")
    public void laTareaEsEliminadaSiCumpleLaCondicion() {
        user.should(seeThat(ValidateTitle.in()));
    }
}
