package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
    DataGenerator data = new DataGenerator();
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
    private static final SelenideElement notMustFill = $(".input__sub");

    public void setPaymentByCard() {
        paymentByCard.click();
    }

    public void setPaymentByCredit() {
        paymentByCredit.click();
    }

    public void setCardNumber(int id) {
        cardNumber.setValue(data.getCardNumber(id));
    }

    public void getPay() {
        paymentButton.click();
    }

    public void fillingInTheFields(int month, int year, int holder, int code) {
        cardMonth.setValue(data.generateMonth(month));
        cardYear.setValue(data.generateYear(year));
        cardHolder.setValue(data.generateHolder(holder));
        cardCode.setValue(data.generateCode(code));
    }

    public void getApprove() {
        notOk.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void getError() {
        notError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void getFillTheForm() {
        notMustFill.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void cleaning() {
        cardNumber.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardMonth.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardYear.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardHolder.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardCode.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
