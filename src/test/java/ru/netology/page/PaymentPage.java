package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {

    private final SelenideElement heading = $("App_appContainer__3jRx1");

    public void DashboardPage() {
        heading.shouldBe(visible);
    }

    private static final SelenideElement paymentByCard = $x("//*[contains(text(),'Купить')]");
    private static final SelenideElement paymentByCredit = $x("//*[contains(text(),'Купить в кредит')]");
    private static final ElementsCollection fields = $$(".input__control");
    private static final SelenideElement cardNumber = fields.get(0);
    private static final SelenideElement cardMonth = fields.get(1);
    private static final SelenideElement cardYear = fields.get(2);
    private static final SelenideElement cardHolder = fields.get(3);
    private static final SelenideElement cardCode = fields.get(4);
    private static final SelenideElement paymentButton = $(By.className("button_view_extra"));
    private static final SelenideElement notOk = $("notification_status_ok");
    private static final SelenideElement notError = $("notification_status_error");


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

    public void getApprove() {
        notOk.shouldBe(Condition.visible);
    }

    public void getError() {
        notError.shouldBe(Condition.visible);
    }

    public static void cleaning() {
        cardNumber.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardMonth.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardYear.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardHolder.doubleClick().sendKeys(Keys.BACK_SPACE);
        cardCode.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
