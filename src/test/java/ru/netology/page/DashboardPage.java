package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("App_appContainer__3jRx1");


    public DashboardPage() {
        heading.shouldBe(visible);
    }
}
