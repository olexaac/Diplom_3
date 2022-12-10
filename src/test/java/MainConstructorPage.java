import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.model.LoginPage;
import ru.yandex.praktikum.model.MainPage;

import java.time.Duration;

import static org.junit.Assert.*;

public class MainConstructorPage {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\1\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options); // Для запуска тестов в яндекс браузере

        //driver = new ChromeDriver(); // Для запуска тестов в хром браузере

        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.open();
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

    @After
    public void cleanUp() {
        driver.quit();
    }
}
