package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class PaymentTest {

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
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getApprove();

        var sqlHelper = new SQLHelper();
        int expected = 1;
        int actual = sqlHelper.getCountOfApprovedPayment();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDeclinePaymentByCardWithRightCard() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(2);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getError();

        var sqlHelper = new SQLHelper();
        int expected = 1;
        int actual = sqlHelper.getCountOfDeclinedPayment();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(0);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(3);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCardWithCardNumberEqualZero() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(4);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(5);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(0, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(2, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(3, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 0, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 2, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongYearMinYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 5, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongYearMaxYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 3, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 4, 1, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 0, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithNumberInsteadOfHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 2, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 3, 1);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithMissingCode() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 0);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongCodeTwoDigitNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 2);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithWrongHolderFourDigitNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 3);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCardWithTextInsteadOfCode() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(1);
        paymentPage.fillingInTheFields(1, 1, 1, 4);
        paymentPage.getPay();
        paymentPage.getFillTheForm();
    }

    @Test
    void shouldApprovePaymentByCardWitchMustBeDeclineIfSendRequestTwice() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCard();
        var paymentPage = new PaymentPage();
        paymentPage.setCardNumber(3);
        paymentPage.fillingInTheFields(1, 1, 1, 1);
        paymentPage.getPay();
        paymentPage.getError();
        paymentPage.getPay();
        paymentPage.getApprove();
    }
}
