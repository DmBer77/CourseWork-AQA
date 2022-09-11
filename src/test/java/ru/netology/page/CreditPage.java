package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreditPage {

    private SelenideElement heading = $("App_appContainer__3jRx1");

    public void DashboardPage() {
        heading.shouldBe(visible);
    }


    private static SelenideElement paymentByCredit = $x("//*[contains(text(),'Кредит по данным карты')]");
    private static SelenideElement cardNumber = $("form-field_theme_alfa-on-white input__control");
    private static SelenideElement cardMonth = $x("//*[contains(text(),'Месяц')] input__control");
    private static SelenideElement cardYear = $x("//*[contains(text(),'Год')] input__control");
    private static SelenideElement cardHolder = $x("//*[contains(text(),'Владелец')] input__control");
    private static SelenideElement cardCode = $x("//*[contains(text(),'CVC/CVV')] input__control");
    private static SelenideElement paymentButton = $x("//*[contains(text(),'Продолжить')]");
    private static SelenideElement notOk = $("notification_status_ok");
    private static SelenideElement notError = $("notification_status_error");


//    public VerificationPage validLogin(DataHelper.AuthInfo info) {
//        login.setValue(info.getLogin());
//        password.setValue(info.getPassword());
//        loginButton.click();
//        return new VerificationPage();
//    }

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
