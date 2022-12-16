import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.model.ForgotPasswordPage;
import ru.yandex.praktikum.model.LoginPage;
import ru.yandex.praktikum.model.RegistrationPage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Авторизация пользователя через кнопку личного кабинета")
    @Description("Проверка появления заголовка на главной странице после успешной авторизации")
    public void userLoginFromPersonalAccount() {
        mainPage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailForUser();
        loginPage.passwordForUser();
        loginPage.clickForLoginUser();
        assertEquals("Соберите бургер", mainPage.isMessageTitle());
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку на главной странице")
    @Description("Проверка появления заголовка на главной странице после успешной авторизации")
    public void userLoginFromMainPage() {
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailForUser();
        loginPage.passwordForUser();
        loginPage.clickForLoginUser();
        assertEquals("Соберите бургер", mainPage.isMessageTitle());
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку в форме регистрации")
    @Description("Проверка появления заголовка на главной странице после успешной авторизации")
    public void userLoginFromRegistrationPage() {
        mainPage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistration();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickForLoginUser();

        loginPage.emailForUser();
        loginPage.passwordForUser();
        loginPage.clickForLoginUser();
        assertEquals("Соберите бургер", mainPage.isMessageTitle());
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку в форме восстановления пароля")
    @Description("Проверка появления заголовка на главной странице после успешной авторизации")
    public void userLoginFromForgotPasswordPage() {
        mainPage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickForLoginUser();

        loginPage.emailForUser();
        loginPage.passwordForUser();
        loginPage.clickForLoginUser();
        assertEquals("Соберите бургер", mainPage.isMessageTitle());
    }
}
