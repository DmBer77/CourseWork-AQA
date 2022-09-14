package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentTest {

    @AfterAll
    static void tearDown() {
        PaymentPage.cleaning();
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
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        PaymentPage.setPaymentByCard();
        PaymentPage.setCardNumber(2);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getApprove();
    }
    @Test
    void shouldDeclinePaymentByCardWithWrongCard() {
        Configuration.holdBrowserOpen = true;
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
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(2);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getApprove();
    }
    @Test
    void shouldDeclinePaymentByCreditWithWrongCard() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(3);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getError();
    }
    @Test
    void shouldFillAllFieldsPaymentByCreditIfClickContinueTwice() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(3);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
        PaymentPage.getError();
        PaymentPage.getPay();
        PaymentPage.getApprove();
    }

//    ---------------------------------------------------------------------------------------------------------

}
