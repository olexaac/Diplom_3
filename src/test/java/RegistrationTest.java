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
import ru.yandex.praktikum.model.RegistrationPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {

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

    @After
    public void cleanUp() {
        driver.quit();
    }
}
