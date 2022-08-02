/* Тестирование web приложения Mail.ru с помощью фреймворка Selenide (https://selenide.org/index.html) */

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMailRu {

    private MainPage mainPage;
    private SignInPage signInPage;
    private InboxPage inboxPage;

    @BeforeAll
    void setUp() {
        //Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
        System.setProperty("chromeoptions.prefs","intl.accept_languages=en");
        open("https://mail.ru/");
        mainPage = new MainPage();
    }

    @Order(1)
    @Test
    public void openMainPage() {
        assertTrue(mainPage.waitIsPageOpen());
    }

    @Order(2)
    @Test
    public void openSignInPage() {
        mainPage.clickMail();
        signInPage = new SignInPage();
        assertTrue(signInPage.waitIsPageOpen());
    }

    @Order(3)
    @Test
    public void makeSignIn() {
        signInPage.inputAccountName();
        signInPage.clickEnterPasswordButton();
        signInPage.waitEnterYourPasswordDialog();
        signInPage.inputPassword();
        signInPage.clickEnterButton();
        inboxPage = new InboxPage();
        assertTrue(inboxPage.waitIsPageOpen());
    }

    @Order(4)
    @Test
    public void writeLetterToMe() {
        inboxPage.clickDropdownButton();
        inboxPage.selectWriteEmail();
        inboxPage.writeLetterToMe();
    }
}