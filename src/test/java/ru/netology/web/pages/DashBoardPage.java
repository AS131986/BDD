package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lombok.val;

import static com.codeborne.selenide.Selenide.*;

public class DashBoardPage {
    public TransferPage successLogin() {
        $x("//*[contains(text(),'Личный кабинет')]").should(Condition.appear);
        $$x("//*[@class='button__content']").filter(Condition.visible).first().doubleClick();
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
    public void testEndSum() {
        $x("//*[@data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").shouldHave(Condition.text("8000"));
    }

}

