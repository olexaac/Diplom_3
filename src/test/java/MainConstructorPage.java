import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.LoginPage;

import static org.junit.Assert.assertEquals;

public class MainConstructorPage extends BaseTest{

    @Before
    public void signIn() {
        mainPage.clickPersonalAccount();

        loginPage = new LoginPage(driver);
        loginPage.emailForUser();
        loginPage.passwordForUser();
        loginPage.clickForLoginUser();
    }

    @Test
    @DisplayName("Переход пользователя из личного кабинета в конструктор по клику на кнопку конструктора")
    @Description("Проверка появления заголовка на главной странице после перехода")
    public void transitionConstructorFromAccount() {
        mainPage.clickPersonalAccount();
        mainPage.clickConstructorButton();

        assertEquals("Соберите бургер", mainPage.isMessageTitle());
    }

    @Test
    @DisplayName("Переход пользователя из личного кабинета в конструктор по клику на логотип")
    @Description("Проверка появления заголовка на главной странице после перехода")
    public void transitionMainPageFromAccount() {
        mainPage.clickPersonalAccount();
        mainPage.clickLogoButton();

        assertEquals("Соберите бургер", mainPage.isMessageTitle());
    }

    @Test
    @DisplayName("Переход к разделу соусов в конструкторе")
    @Description("Проверка изменения наименования локатора для выбранного раздела")
    public void transitionBlockSauces() {
        mainPage.clickSauces();

        assertEquals("Соусы", mainPage.changedClassConstructor());
    }

    @Test
    @DisplayName("Переход к разделу начинок в конструкторе")
    @Description("Проверка изменения наименования локатора для выбранного раздела")
    public void transitionBlockFilling() {
        mainPage.clickFillings();

        assertEquals("Начинки", mainPage.changedClassConstructor());
    }

    @Test
    @DisplayName("Переход к разделу булок в конструкторе")
    @Description("Проверка изменения наименования локатора для выбранного раздела")
    public void transitionBlockBuns() {
        mainPage.clickSauces();
        mainPage.clickBuns();

        assertEquals("Булки", mainPage.changedClassConstructor());
    }
}
