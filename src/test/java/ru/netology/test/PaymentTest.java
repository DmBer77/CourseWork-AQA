package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLHelper;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class PaymentTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterAll
    static void tearDown() {
        cleanDatabase();
    }

    @Test
    void shouldApprovePaymentByCard() {
        open("http://localhost:8080");
        PaymentPage.setPaymentByCard();
        PaymentPage.setCardNumber(1);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getApprove();
    }

    @Test
    void shouldDeclinePaymentByCardWithRightCard() {
        open("http://localhost:8080");
        PaymentPage.setPaymentByCard();
        PaymentPage.setCardNumber(2);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongCard() {
        open("http://localhost:8080");
        PaymentPage.setPaymentByCard();
        PaymentPage.setCardNumber(3);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getError();
    }

    @Test
    void shouldApprovePaymentByCredit() {
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(1);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getApprove();
    }

    @Test
    void shouldDeclinePaymentByCreditWithRightCard() {
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(2);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongCard() {
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(3);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getError();
    }

    @Test
    void shouldFillAllFieldsPaymentByCreditIfClickContinueTwice() {
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(3);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getError();
        PaymentPage.getPay();
        PaymentPage.getApprove();
    }

    @Test
    void shouldReceiveElementFromBD() {
        SQLHelper.getResponseFromDB();
    }
}
