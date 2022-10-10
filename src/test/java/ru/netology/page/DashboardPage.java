package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private static final SelenideElement heading = $(".Order_cardPreview__47B2k");
    private final SelenideElement paymentByCard = $x("//*[contains(text(),'Купить')]");
    private final SelenideElement paymentByCredit = $x("//*[contains(text(),'Купить в кредит')]");

    public void setPaymentByCard() {
        paymentByCard.click();
    }

    public void setPaymentByCredit() {
        paymentByCredit.click();
    }

//
//    private final ElementsCollection fields = $$(".input__control");
//    private final SelenideElement cardNumber = fields.get(0);
//    private final SelenideElement cardMonth = fields.get(1);
//    private final SelenideElement cardYear = fields.get(2);
//    private final SelenideElement cardHolder = fields.get(3);
//    private final SelenideElement cardCode = fields.get(4);
//    private final ElementsCollection button = $$(".button");
//    private final SelenideElement paymentButton = button.get(2);
//    private final SelenideElement notOk = $(".notification_status_ok");
//    private final SelenideElement notError = $(".notification_status_error");
//    private final SelenideElement notMustFill = $(".input__sub");

}
