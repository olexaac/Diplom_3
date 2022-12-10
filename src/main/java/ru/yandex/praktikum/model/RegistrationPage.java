package ru.yandex.praktikum.model;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final By FILL_INPUT_NAME = By.xpath("//input[@name='name']");
    private final By FILL_INPUT_EMAIL = By.xpath("//label[text() = 'Email']/../input");
    private final By FILL_INPUT_PASSWORD = By.xpath("//input[@name='Пароль']");
    private final By SEARCH_REGISTRATION_BUTTON = By.xpath("//button[.='Зарегистрироваться']");
    private final By CHECK_BUTTON_LOGIN_USER = By.xpath("//button[.='Войти']");
    private final By CHECK_MESSAGE_INCORRECT_REGISTRATION = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By SEARCH_BUTTON_FOR_LOGIN = By.xpath("//a[@href='/login']");

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение имени для нового пользователя при регистрации")
    public void nameForUser() {
        String firstName = RandomStringUtils.randomAlphabetic(7);
        driver.findElement(FILL_INPUT_NAME).sendKeys(firstName);
    }

    @Step("Заполнение адреса электронной почты для нового пользователя при регистрации")
    public void emailForUser() {
        String emailUser = RandomStringUtils.randomAlphabetic(7) + "@stellarburgers.test";
        driver.findElement(FILL_INPUT_EMAIL).sendKeys(emailUser);
    }

    @Step("Заполнение валидного пароля для нового пользователя при регистрации")
    public void passwordForUser() {
        String passwordUser = RandomStringUtils.randomAlphabetic(6);
        driver.findElement(FILL_INPUT_PASSWORD).sendKeys(passwordUser);
    }

    @Step("Заполнения пароля, несоответствующего длине, для нового пользователя при регистрации")
    public void passwordWrongForUser() {
        String passwordUser = RandomStringUtils.randomAlphabetic(5);
        driver.findElement(FILL_INPUT_PASSWORD).sendKeys(passwordUser);
    }

    @Step("Клик по кнопке регистрации после заполнения полей")
    public void clickForRegisterUser() {
        driver.findElement(SEARCH_REGISTRATION_BUTTON).click();
    }

    @Step("Извлечение текста кнопки входа после успешной регистрации для проверки в тестах")
    public Object isButtonAfterCreatedNewUser() {
        return driver.findElement(CHECK_BUTTON_LOGIN_USER).getAttribute("innerHTML");
    }

    @Step("Извлечения текста сообщения об ошибке при попытке регистрации с коротким паролем")
    public Object isMessageAboutError() {
        return driver.findElement(CHECK_MESSAGE_INCORRECT_REGISTRATION).getAttribute("innerHTML");
    }

    @Step("Клик по кнопке входа со страницы регистрации")
    public void clickForLoginUser() {
        driver.findElement(SEARCH_BUTTON_FOR_LOGIN).click();
    }
}
