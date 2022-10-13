package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLHelper;
import ru.netology.page.CreditPage;
import ru.netology.page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class PaymentByCreditTest {

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
    void shouldApprovePaymentByCredit() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getApprove();

        String expected = "APPROVED";
        String actual = SQLHelper.getStatusOfCredit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDeclinePaymentByCreditWithRightCard() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(2);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getError();

        String expected = "DECLINED";
        String actual = SQLHelper.getStatusOfCredit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(0);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(3);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getError();
    }

    @Test
    void shouldDeclinePaymentByCreditWithCardNumberEqualZero() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(4);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfCardNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(5);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(0, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(2, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfMonth() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(3, 1, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 0, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 2, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongYearMinYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 5, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongYearMaxYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 3, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfYear() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 4, 1, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 0, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithNumberInsteadOfHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 2, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongHolder() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 3, 1);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithMissingCode() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 0);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongCodeTwoDigitNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 2);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithWrongHolderFourDigitNumber() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 3);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldDeclinePaymentByCreditWithTextInsteadOfCode() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(1);
        creditPage.fillingInTheFields(1, 1, 1, 4);
        creditPage.getPay();
        creditPage.getFillTheForm();
    }

    @Test
    void shouldApprovePaymentByCreditWitchMustBeDeclineIfSendRequestTwice() {
        open("http://localhost:8080");
        var dashboardPage = new DashboardPage();
        dashboardPage.setPaymentByCredit();
        var creditPage = new CreditPage();
        creditPage.setCardNumber(3);
        creditPage.fillingInTheFields(1, 1, 1, 1);
        creditPage.getPay();
        creditPage.getError();
        creditPage.getPay();
        creditPage.getApprove();
    }
}