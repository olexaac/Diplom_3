import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.AccountPage;
import ru.yandex.praktikum.model.LoginPage;

import static org.junit.Assert.assertEquals;

public class AccountTest extends BaseTest {

    @Before
    public void signIn() {
        mainPage.clickPersonalAccount();

        loginPage = new LoginPage(driver);
        loginPage.emailForUser();
        loginPage.passwordForUser();
        loginPage.clickForLoginUser();
    }

    @Test
    @DisplayName("Переход пользователя в личный кабинет")
    @Description("Проверка появления заголовка 'Профиль' на странице личного кабинета")
    public void transitionPersonalAccount() {
        mainPage.clickPersonalAccount();

        AccountPage accountPage = new AccountPage(driver);
        assertEquals("Профиль", accountPage.isEmailValue());
    }
}
