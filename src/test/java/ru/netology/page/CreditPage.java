package ru.netology.page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.time.Duration;

public class CreditPage {

    DataGenerator data = new DataGenerator();
    DashboardPage dashboard = new DashboardPage();

    public void setPaymentByCredit() {
        dashboard.paymentByCredit.click();
    }

    public void setCardNumber(int id) {
        dashboard.cardNumber.setValue(data.getCardNumber(id));
    }

    public void getPay() {
        dashboard.paymentButton.click();
    }

    public void fillingInTheFields(int month, int year, int holder, int code) {
        dashboard.cardMonth.setValue(data.generateMonth(month));
        dashboard.cardYear.setValue(data.generateYear(year));
        dashboard.cardHolder.setValue(data.generateHolder(holder));
        dashboard.cardCode.setValue(data.generateCode(code));
    }

    public void getApprove() {
        dashboard.notOk.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void getError() {
        dashboard.notError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void getFillTheForm() {
        dashboard.notMustFill.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void cleaning() {
        dashboard.cardNumber.doubleClick().sendKeys(Keys.BACK_SPACE);
        dashboard.cardMonth.doubleClick().sendKeys(Keys.BACK_SPACE);
        dashboard.cardYear.doubleClick().sendKeys(Keys.BACK_SPACE);
        dashboard.cardHolder.doubleClick().sendKeys(Keys.BACK_SPACE);
        dashboard.cardCode.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
