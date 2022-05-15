package ru.netology.web.pages;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo authInfo) {
        $x("//input[@name='login']").val(authInfo.getLogin());
        $x("//input[@name='password']").val(authInfo.getPassword());
        $(withText("Продолжить")).click();
        return new VerificationPage();
    }
}
