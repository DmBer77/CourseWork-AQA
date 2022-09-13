package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentTest {



//    @AfterAll
//    static void tearDown() {
//        PaymentPage.cleaning();
//    }

    @Test
    void shouldFillAllFieldsPaymentByCard() {
//        var paymentPage = open("http://185.119.57.197:9999", PaymentPage.class);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        PaymentPage.setPaymentByCard();
        PaymentPage.setCardNumber(1);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
    }

    @Test
    void shouldFillAllFieldsPaymentByCredit() {
//        var paymentPage = open("http://185.119.57.197:9999", PaymentPage.class);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        PaymentPage.setPaymentByCredit();
        PaymentPage.setCardNumber(2);
        PaymentPage.fillingInTheFields();
        PaymentPage.getPay();
    }
}
