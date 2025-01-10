package co.tweek.qa.usersinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://tweek.so/")
public class MainPage extends PageObject {
    public static final Target INPUT = Target.the("Input").located(By.id("//*[@id='root']"));
    public static final Target LIST_TASKS = Target.the("List tasks").located(By.id("(//div[@class='_body_1mp4m_93'])[1]"));

}
