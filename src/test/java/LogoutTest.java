import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.AccountPage;
import ru.yandex.praktikum.model.LoginPage;

import static org.junit.Assert.assertEquals;

public class LogoutTest extends BaseTest {

    @Before
    public void signIn() {
        mainPage.clickPersonalAccount();

        loginPage = new LoginPage(driver);
        loginPage.emailForUser();
        loginPage.passwordForUser();
        loginPage.clickForLoginUser();
    }

    @Test
    @DisplayName("Выход пользователя из учетной записи")
    @Description("Проверка появления заголовка на странице авторизации после выхода")
    public void signOutPersonalAccount() {
        mainPage.clickPersonalAccount();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickForSignOutUser();

        loginPage.isTextLoginPage();
        assertEquals("Вход", loginPage.isTextLoginPage());
    }
}
