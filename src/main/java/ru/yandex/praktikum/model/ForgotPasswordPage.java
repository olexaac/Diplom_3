package ru.yandex.praktikum.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final By SEARCH_BUTTON_FOR_LOGIN = By.xpath("//a[@href='/login']");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке входа со страницы восстановления пароля")
    public void clickForLoginUser() {
        driver.findElement(SEARCH_BUTTON_FOR_LOGIN).click();
    }
}
