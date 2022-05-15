package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TransferPage {
    public void successfulTransfer(DataHelper.CardInfo cardInfo) {
        $x("//input[@type='text']").val("500");
        $x("//input[@type='tel']").val(cardInfo.getSecondCard());
        $(withText("Пополнить")).click();
    }
}
