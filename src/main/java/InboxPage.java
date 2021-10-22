import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InboxPage extends BasePage {

    public InboxPage(){
        super($("div.application-mail__layout"));
    }

    public void clickDropdownButton() {
        COMPONENT_CONTAINER
                .$("span.button2__ico")
                .shouldBe(Condition.enabled)
                .click();
    }

    public void selectWriteEmail() {
        COMPONENT_CONTAINER
                .$$("span.list-item__text")
                .get(0).shouldBe(Condition.enabled)
                .click();
    }

    public void writeLetterToMe() {
                $("input[name='Subject']").setValue("Hello");
                $x("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]").setValue("Test mail");
                $x("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span/span").click();
    }
}