package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private static final SelenideElement heading = $(".Order_cardPreview__47B2k");










    public DashboardPage() {
        heading.shouldBe(visible);
    }
}
