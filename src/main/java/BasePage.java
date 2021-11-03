import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public abstract class BasePage {

    public SelenideElement componentContainer;

    public BasePage(SelenideElement component_container) {
        this.componentContainer = component_container;
    }

    /*
    Этот метод работает без ожидания, в случае, если элемент не отображён на экране, то exception не будет сгенерирован
    Нам вернётся true или false
     */
    public boolean isPageOpen() {
        return componentContainer
                .isDisplayed();
    }

    /*
    Этот метод работает c ожиданием, в случае, если элемент не отображён на экране, то exception будет сгенерирован
    */
    public void waitPageOpen() {
        componentContainer
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public boolean waitIsPageOpen() {
        try {
            waitPageOpen();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(SelenideElement element) {
        element.shouldBe(Condition.enabled).click();
    }

    public String getTextOnElement(SelenideElement element) {
        return element.getText().trim();
    }
}