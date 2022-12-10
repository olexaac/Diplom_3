import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.model.ForgotPasswordPage;
import ru.yandex.praktikum.model.LoginPage;
import ru.yandex.praktikum.model.MainPage;
import ru.yandex.praktikum.model.RegistrationPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;
    private MainPage mainPage;

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
    }

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

    @After
    public void cleanUp() {
        driver.quit();
    }
}
