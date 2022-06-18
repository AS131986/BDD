package ru.netology.web.test;
import com.codeborne.selenide.Condition;
import ru.netology.web.data.DataHelper;
import ru.netology.web.pages.LoginPage;
import org.junit.jupiter.api.Test;
import ru.netology.web.pages.TransferPage;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.$x;
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
        var cardInfo = DataHelper.getCardInfoInverted("1000");
        var transferPage2 = new TransferPage();
        transferPage2.successfulTransfer(cardInfo);
        $x("//*[@data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").shouldHave(Condition.text(Integer.toString(dashboardPage.getFirstCardBalance())));
        $x("//*[@data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").shouldHave(Condition.text(Integer.toString(dashboardPage.getSecondCardBalance())));

    }
}
