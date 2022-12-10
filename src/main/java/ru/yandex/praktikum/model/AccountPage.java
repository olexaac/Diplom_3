package ru.yandex.praktikum.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private final By CHECK_EMAIL_USER = By.xpath("//a[@href='/account/profile']");
    private final By SEARCH_LOGOUT_BUTTON = By.xpath("//button[.='Выход']");
    private final WebDriver driver;

    public AccountPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Извлечение текста заголовка после выхода из профиля для проверки в тестах")
    public Object isEmailValue() {
        return driver.findElement(CHECK_EMAIL_USER).getAttribute("innerHTML");
    }

    @Step("Клик по кнопке выхода из профиля пользователя")
    public void clickForSignOutUser() {
        driver.findElement(SEARCH_LOGOUT_BUTTON).click();
    }
}
