package ru.netology.web.data;
import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {return new AuthInfo("vasya", "qwerty123"); }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authinfo) {
        return new VerificationCode("12345");
    }
    @Value
    public static class CardInfo {
        private String firstCard;
        private String secondCard;
    }
    public static CardInfo getCardInfo() {return new CardInfo("5559 0000 0000 0001", "5559 0000 0000 0002");}

    @Value
    public static class TransferInfo {
        private String sum;
        private String where;
    }
}
