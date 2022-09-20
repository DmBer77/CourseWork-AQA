package ru.netology.test;

import com.codeborne.selenide.Configuration;
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
    PaymentPage paymentPage = new PaymentPage();

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
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getApprove();
    }

    @Test
    void shouldDeclinePaymentByCardWithRightCard() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(2);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingCardNumber() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(0);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongCardNumber() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(3);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCardWithCardNumberEqualZero() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(4);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfCardNumber() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(5);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingMonth() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(0, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongMonth() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(2, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfMonth() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(3, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingYear() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 0, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongYear() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 2, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongYearMinYear() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 5, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }
    @Test
    void shouldDeclinePaymentByCardWithWrongYearMaxYear() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 3, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfYear() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 4, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingHolder() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 0, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithNumberInsteadOfHolder() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 2, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongHolder() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 3, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingCode() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 0);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongCodeTwoDigitNumber() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 2);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongHolderFourDigitNumber() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 3);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfCode() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCard();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 4);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

//------------------------------------------------------------------------------
    @Test
    void shouldApprovePaymentByCreditEverythingOK() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getApprove();
    }

    @Test
    void shouldApprovePaymentByCreditIfFieldNumberIsEmpty() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(4);
        paymentPage.fillingInTheFields(2, 2, 2, 2);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldApprovePaymentByCreditIfFieldMonthIsEmpty() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(0, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldApprovePaymentByCreditIfFieldYearIsEmpty() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 0, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldApprovePaymentByCreditIfFieldHolderIsEmpty() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 0, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldApprovePaymentByCreditIfFieldCodeIsEmpty() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 0);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldApprovePaymentByCreditIfAllFieldAreEmpty() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(0);
        paymentPage.fillingInTheFields(0, 0, 0, 0);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithRightCard() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(2);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongCard() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(3);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getError();
    }

    @Test
    void shouldFillAllFieldsPaymentByCreditIfClickContinueTwice() {
        open("http://localhost:8080");
        paymentPage.setPaymentByCredit();
        paymentPage.setCardNumber(3);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getPay();
        paymentPage.getApprove();
    }

    @Test
    void shouldReceiveElementFromBD() {
        SQLHelper.getResponseFromDB();
    }
}
