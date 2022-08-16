package ru.netology.web.test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import ru.netology.web.data.DataHelper;
import ru.netology.web.pages.DashBoardPage;
import ru.netology.web.pages.LoginPage;
import org.junit.jupiter.api.Test;
import ru.netology.web.pages.TransferPage;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        var secondCardBalanceStart = dashboardPage.getSecondCardBalance();
        var firstCardBalanceStart = dashboardPage.getFirstCardBalance();
        var transferPage = dashboardPage.successLogin();
        var cardInfo = DataHelper.getCardInfoInverted("1000");
        var transferPage2 = new TransferPage();
        transferPage2.successfulTransfer(cardInfo);
        var secondCardBalanceFinish = dashboardPage.getSecondCardBalance();
        var firstCardBalanceFinish = dashboardPage.getFirstCardBalance();
        assertEquals(secondCardBalanceStart, secondCardBalanceFinish + 1000);
        assertEquals(firstCardBalanceStart, firstCardBalanceFinish - 1000);
    }
}
