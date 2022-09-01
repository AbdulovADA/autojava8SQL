package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private SelenideElement verificationField = $("[data-test-id='code'] input");
    private SelenideElement verificationButton = $("button.button");

    public DashboardPage validVerify(String info) {
        verificationField.setValue(info);
        verificationButton.click();
        return new DashboardPage();
    }
}