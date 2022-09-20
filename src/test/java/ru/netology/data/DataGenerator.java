package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    public DataGenerator() {
    }

    static Faker faker = new Faker((new Locale("ru")));

    public String getCardNumber(int id) {
        return switch (id) {
            case (0) -> "";
            case (1) -> "1111 2222 3333 4444";
            case (2) -> "5555 6666 7777 8888";
            case (3) -> "5544 6677 2233 9900";
            case (4) -> "0000 0000 0000 0000";
            case (5) -> "number";
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    public String generateMonth(int month) {
        return switch (month) {
            case (0) -> "";
            case (1) -> String.valueOf(faker.number().numberBetween(10, 12));
            case (2) -> "15";
            case (3) -> "month";
            default -> "00";
        };
    }

    public String generateYear(int year) {
        int yearStart = LocalDate.now().getYear() + 1;
        int yearFinish = yearStart + 5;
        return switch (year) {
            case (0) -> "";
            case (1) -> String.valueOf(faker.number().numberBetween(yearStart, yearFinish)).substring(2);
            case (2) -> String.valueOf(faker.number().numberBetween(yearStart, yearFinish)).substring(3);
            case (3) -> "99";
            case (4) -> "year";
            default -> "00";
        };
    }

    public String generateHolder(int holder) {
        return switch (holder) {
            case (0) -> "";
            case (1) -> "STEVEN ROGERS";
            case (2) -> String.valueOf(faker.number().numberBetween(1, 99));
            case (3) -> faker.name().fullName().toUpperCase();
            default -> "00";
        };
    }

    public String generateCode(int code) {
        return switch (code) {
            case (0) -> "";
            case (1) -> String.valueOf(faker.number().numberBetween(100, 999));
            case (2) -> String.valueOf(faker.number().numberBetween(0, 99));
            case (3) -> String.valueOf(faker.number().numberBetween(1000, 1999));
            case (4) -> "code";
            default -> "000";
        };
    }
}