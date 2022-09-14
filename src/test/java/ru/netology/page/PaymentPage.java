package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {

    private static final SelenideElement paymentByCard = $x("//*[contains(text(),'Купить')]");
    private static final SelenideElement paymentByCredit = $x("//*[contains(text(),'Купить в кредит')]");
    private static final ElementsCollection fields = $$(".input__control");
    private static final SelenideElement cardNumber = fields.get(0);
    private static final SelenideElement cardMonth = fields.get(1);
    private static final SelenideElement cardYear = fields.get(2);
    private static final SelenideElement cardHolder = fields.get(3);
    private static final SelenideElement cardCode = fields.get(4);
    private static final ElementsCollection button = $$(".button");
    private static final SelenideElement paymentButton = button.get(2);
    private static final SelenideElement notOk = $(".notification_status_ok");
    private static final SelenideElement notError = $(".notification_status_error");

    public static void setPaymentByCard() {
        paymentByCard.click();
    }

    public static void setPaymentByCredit() {
        paymentByCredit.click();
    }

    public static void setCardNumber(int id) {
        cardNumber.setValue(DataGenerator.getCardNumber(id));
    }

    public static void getPay() {
        paymentButton.click();
    }

    public static void fillingInTheFields() {
        cardMonth.setValue(DataGenerator.generateMonth());
        cardYear.setValue(DataGenerator.generateYear());
        cardHolder.setValue(DataGenerator.generateHolder("en"));
        cardCode.setValue(DataGenerator.generateCode());
    }

    public static void getApprove() {
        notOk.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void getError() {
        notError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void cleaning() {
        cardNumber.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardMonth.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardYear.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardHolder.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardCode.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
