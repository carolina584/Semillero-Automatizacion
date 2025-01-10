package co.tweek.qa.usersinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Detail {

    public static final Target TEXTAREA_TITLE = Target.the("Textarea title").located(By.xpath("//*[@id=':r2q:']"));
    public static final Target TEXTAREA_BODY = Target.the("Textarea body").located(By.xpath("//*[@id=':r3o:']"));
    public static final Target CHECK_STATUS = Target.the("Check status").located(By.xpath("//*[@id=':r3o:']/div[2]/div[2]"));

    public static final Target DELETE_BUTTON = Target.the("Delete button").located(By.xpath("//*[@id=':r52:']/div[1]/div[2]/div[1]"));

}
