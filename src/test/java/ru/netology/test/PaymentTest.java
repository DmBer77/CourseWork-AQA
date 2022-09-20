package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLHelper;
import ru.netology.page.CreditPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class PaymentTest {

    PaymentPage paymentPage = new PaymentPage();
    CreditPage creditPage = new CreditPage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void setUp() {
        cleanDatabase();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    void shouldApprovePaymentByCard() {
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
    void shouldApprovePaymentByCredit() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getApprove();
    }

    @Test
    void shouldDeclinePaymentByCreditWithRightCard() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(2);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingCardNumber() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(0);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongCardNumber() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(3);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCreditWithCardNumberEqualZero() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(4);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfCardNumber() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(5);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingMonth() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(0, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongMonth() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(2, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfMonth() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(3, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingYear() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 0, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongYear() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 2, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongYearMinYear() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 5, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongYearMaxYear() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 3, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfYear() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 4, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingHolder() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 0, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithNumberInsteadOfHolder() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 2, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongHolder() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 3, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingCode() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 0);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongCodeTwoDigitNumber() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 2);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongHolderFourDigitNumber() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 3);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfCode() {
        open("http://localhost:8080");
        creditPage.setPaymentByCredit();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 4);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    //------------------------------------------------------------------------------
    @Test
    void shouldReceiveElementFromBDApprovedCredit() {
        SQLHelper sqlHelper = new SQLHelper();

        int expected = 4;
        int actual = sqlHelper.getCountOfApprovedCredit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReceiveElementFromBDDeclinedPayment() {
        SQLHelper sqlHelper = new SQLHelper();

        int expected = 1;
        int actual = sqlHelper.getCountOfDeclinedPayment();

        Assertions.assertEquals(expected, actual);
    }
}
