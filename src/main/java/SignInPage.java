import com.codeborne.selenide.Condition;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends BasePage {

    public SignInPage() {
        super($("div.login-panel")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)));
    }

    public boolean waitIsPageOpen() {
        try {
            waitPageOpen();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void inputAccountName() {
        componentContainer
                .$("input[name='username']")
                .setValue("testing-mailbox");
    }

    public void inputPassword() {
        componentContainer
                .$("input[name='password']")
                .shouldBe(Condition.visible,Duration.ofSeconds(30))
                .setValue("testing12345");
    }

    public void clickEnterPasswordButton() {
        componentContainer
                .$("button[data-test-id='next-button']")
                .shouldBe(Condition.enabled)
                .click();
    }

    public void waitEnterYourPasswordDialog() {
        componentContainer
                .$("h2[data-test-id='header-text']")
                .shouldBe(Condition.visible)
                .click();
    }

    public void clickEnterButton() {
        componentContainer
                .$("button[data-test-id='submit-button']")
                .shouldBe(Condition.visible)
                .click();
    }
}