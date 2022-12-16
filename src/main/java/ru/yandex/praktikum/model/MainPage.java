package ru.yandex.praktikum.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final static String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private final By SEARCH_ACCOUNT_BUTTON_HEADER = By.xpath("//a[@href='/account']");
    private final By SEARCH_ACCOUNT_BUTTON_MAIN_PAGE = By.xpath("//button[.='Войти в аккаунт']");
    private final By SEARCH_CONSTRUCTOR_BUTTON = By.xpath("//p[.='Конструктор']");
    private final By CHECK_MESSAGE_IN_TITLE = By.xpath("//h1[.='Соберите бургер']");
    private final By SEARCH_LOGO_BUTTON = By.className("AppHeader_header__logo__2D0X2");
    private final By SEARCH_SAUCES_BUTTON = By.xpath("//span[.='Соусы']");
    private final By SEARCH_FILLINGS_BUTTON = By.xpath("//span[.='Начинки']");
    private final By SEARCH_BUNS_BUTTON = By.xpath("//span[.='Булки']");
    private final By CHECK_CHANGED_CLASS_CONSTRUCTOR = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    @Step("Клик по кнопке перехода в аккаунт в хедере")
    public void clickPersonalAccount() {
        driver.findElement(SEARCH_ACCOUNT_BUTTON_HEADER).click();
    }

    @Step("Клик по кнопке перехода в аккаунт на главной странице")
    public void clickLoginButton() {
        driver.findElement(SEARCH_ACCOUNT_BUTTON_MAIN_PAGE).click();
    }

    @Step("Клик по кнопке конструктора")
    public void clickConstructorButton() {
        driver.findElement(SEARCH_CONSTRUCTOR_BUTTON).click();
    }

    @Step("Извлечение текста заголовка на главной странице для проверок в тестах")
    public Object isMessageTitle() {
        return driver.findElement(CHECK_MESSAGE_IN_TITLE).getAttribute("innerHTML");
    }

    @Step("Клик по кнопке логотипа")
    public void clickLogoButton() {
        driver.findElement(SEARCH_LOGO_BUTTON).click();
    }

    @Step("Клик по якорной ссылке для перехода к разделам соусов")
    public void clickSauces() {
        driver.findElement(SEARCH_SAUCES_BUTTON).click();
    }

    @Step("Клик по якорной ссылке для перехода к разделам начинок")
    public void clickFillings() {
        driver.findElement(SEARCH_FILLINGS_BUTTON).click();
    }

    @Step("Клик по якорной ссылке для перехода к разделам булок")
    public void clickBuns() {
        driver.findElement(SEARCH_BUNS_BUTTON).click();
    }

    @Step("Извлечения наименования выбранных разделов конструктора для проверок в тестах")
    public Object changedClassConstructor() {
        return driver.findElement(CHECK_CHANGED_CLASS_CONSTRUCTOR).getAttribute("innerHTML");
    }
}
