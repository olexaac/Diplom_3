import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.model.AccountPage;
import ru.yandex.praktikum.model.LoginPage;
import ru.yandex.praktikum.model.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LogoutTest {

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
        assertEquals("Соберите бургер", mainPage.isMessageTitle());
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

    @After
    public void cleanUp() {
        driver.quit();
    }
}
