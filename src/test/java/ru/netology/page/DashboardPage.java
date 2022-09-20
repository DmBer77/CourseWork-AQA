package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {

    private static final SelenideElement heading = $(".Order_cardPreview__47B2k");
    public final SelenideElement paymentByCard = $x("//*[contains(text(),'Купить')]");
    public final SelenideElement paymentByCredit = $x("//*[contains(text(),'Купить в кредит')]");
    public final ElementsCollection fields = $$(".input__control");
    public final SelenideElement cardNumber = fields.get(0);
    public final SelenideElement cardMonth = fields.get(1);
    public final SelenideElement cardYear = fields.get(2);
    public final SelenideElement cardHolder = fields.get(3);
    public final SelenideElement cardCode = fields.get(4);
    public final ElementsCollection button = $$(".button");
    public final SelenideElement paymentButton = button.get(2);
    public final SelenideElement notOk = $(".notification_status_ok");
    public final SelenideElement notError = $(".notification_status_error");
    public final SelenideElement notMustFill = $(".input__sub");

}
