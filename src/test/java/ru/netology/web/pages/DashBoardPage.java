package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lombok.val;
import ru.netology.web.data.DataHelper;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selenide.*;

public class DashBoardPage {
    public TransferPage successLogin() {
        getFirstCardBalance();
        getSecondCardBalance();
        $x("//*[contains(text(),'Личный кабинет')]").should(Condition.appear);
        $$x("//*[@class='button__content']").filter(Condition.visible).first().click();
        return new TransferPage();
    }


    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public void Dashboard() {
    }


    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }
    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public int getSecondCardBalance() {
        val text = cards.get(1).text();
        return extractBalance(text);
    }

}

