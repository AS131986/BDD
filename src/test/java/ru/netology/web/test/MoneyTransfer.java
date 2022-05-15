package ru.netology.web.test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.pages.DashBoardPage;
import ru.netology.web.pages.LoginPage;
import org.junit.jupiter.api.Test;
import ru.netology.web.pages.TransferPage;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransfer {
    @Test
    void shouldTransferMoney() {
        holdBrowserOpen = true;
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verifyInfo = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        var transferPage = dashboardPage.successLogin();
        var cardInfo = DataHelper.getCardInfo();
        var transferPage2 = new TransferPage();
        transferPage2.successfulTransfer(cardInfo);
        dashboardPage.testEndSum();
    }
}
