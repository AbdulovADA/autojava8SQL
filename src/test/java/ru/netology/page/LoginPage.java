package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginField = $("[data-test-id='login'] input");
    private SelenideElement passwordField = $("[data-test-id='password'] input");
    private SelenideElement loginButton = $("button.button");
    private SelenideElement errorMessage = $("[data-test-id='error-notification']");

    public LoginPage() {
        loginField.shouldBe(Condition.visible);
        passwordField.shouldBe(Condition.visible);
        loginButton.shouldBe(Condition.visible);
    }

    public VerificationPage validLogin(String login, String password) {
        enterLogin(login, password);
        return new VerificationPage();
    }

    public void enterLogin(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }

    public void cleanInputField() {
        loginField.sendKeys(Keys.LEFT_CONTROL + "A");
        loginField.sendKeys(Keys.BACK_SPACE);
        passwordField.sendKeys(Keys.LEFT_CONTROL + "A");
        passwordField.sendKeys(Keys.BACK_SPACE);
    }

    public void errorNotification() {
        errorMessage.shouldBe(Condition.visible);
        errorMessage.find("button").click();
    }
}