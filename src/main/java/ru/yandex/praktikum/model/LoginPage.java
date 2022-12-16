package ru.yandex.praktikum.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By SEARCH_REGISTER_LINK = By.xpath("//a[@href='/register']");
    private final By FILL_INPUT_EMAIL = By.xpath("//label[text() = 'Email']/../input");
    private final By FILL_INPUT_PASSWORD = By.xpath("//input[@name='Пароль']");
    private final By SEARCH_LOGIN_BUTTON = By.xpath("//button[.='Войти']");
    private final By SEARCH_FORGOT_PASSWORD_LINK = By.xpath("//a[@href='/forgot-password']");
    private final By CHECK_TEXT_IN_LOGIN_PAGE = By.xpath("//h2[.='Вход']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке регистрации")
    public void clickRegistration() {
        driver.findElement(SEARCH_REGISTER_LINK).click();
    }

    @Step("Заполнение адреса электорнной почты текущего пользователя для входа")
    public void emailForUser() {
        String emailUser = "meoaebp@test.test";
        driver.findElement(FILL_INPUT_EMAIL).sendKeys(emailUser);
    }

    @Step("Заполнение пароля текущего пользователя для входа")
    public void passwordForUser() {
        String passwordUser = "hCAfcRP";
        driver.findElement(FILL_INPUT_PASSWORD).sendKeys(passwordUser);
    }

    @Step("Клик по кнопке входа после заполнения всех полей")
    public void clickForLoginUser() {
        driver.findElement(SEARCH_LOGIN_BUTTON).click();
    }

    @Step("Клик по кнопке восстановления пароля")
    public void clickForgotPassword() {
        driver.findElement(SEARCH_FORGOT_PASSWORD_LINK).click();
    }

    @Step("Извлечения текста заголовка на странице авторизации для проверки в тестах")
    public Object isTextLoginPage() {
        return driver.findElement(CHECK_TEXT_IN_LOGIN_PAGE).getAttribute("innerHTML");
    }
}
