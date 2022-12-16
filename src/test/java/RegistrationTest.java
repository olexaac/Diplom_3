import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.LoginPage;
import ru.yandex.praktikum.model.RegistrationPage;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest {

    @Before
    public void transitionRegistrationPage() {
        mainPage.clickPersonalAccount();

        loginPage = new LoginPage(driver);
        loginPage.clickRegistration();
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    @Description("Проверка появления кнопки 'Войти' на странице авторизации после успешной регистрации")
    public void userCanBeCreated() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.nameForUser();
        registrationPage.emailForUser();
        registrationPage.passwordForUser();
        registrationPage.clickForRegisterUser();

        assertEquals("Войти", registrationPage.isButtonAfterCreatedNewUser());
    }

    @Test
    @DisplayName("Регистрация пользователя с несоответствующим по длине паролем")
    @Description("Проверка сообщения об ошибке")
    public void userCanNotBeCreated() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.nameForUser();
        registrationPage.emailForUser();
        registrationPage.passwordWrongForUser();
        registrationPage.clickForRegisterUser();

        assertEquals("Некорректный пароль", registrationPage.isMessageAboutError());
    }
}
