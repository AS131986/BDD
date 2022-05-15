package ru.netology.web.pages;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    public DashBoardPage validVerify(DataHelper.VerificationCode verificationCode) {
        $x("//input[@name='code']").val(verificationCode.getCode());
        $(withText("Продолжить")).click();
        return new DashBoardPage();
    }
}
