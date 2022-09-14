package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    public DataGenerator() {
    }

    static Faker faker = new Faker((new Locale("ru")));

    public static String getCardNumber(int id) {
        if (id == 1) {
            return "1111 2222 3333 4444";
        }
        if (id == 2) {
            return "5555 6666 7777 8888";
        } else {
            return "5544 6677 2233 9900";
        }
    }

    public static String generateMonth() {
        int month = faker.number().numberBetween(1, 12);
        String res = null;
        if (month < 10) {
            res = "0" + month;
        } else {
            res = String.valueOf(month);
        }
        return res;
    }

    public static String generateYear() {
        int yearStart = LocalDate.now().getYear() + 1;
        int yearFinish = yearStart + 5;
        return String.valueOf(faker.number().numberBetween(yearStart, yearFinish)).substring(2);
    }

    public static String generateHolder(String locale) {
        return faker.name().fullName().toUpperCase();
    }

    public static String generateCode() {
        return String.valueOf(faker.number().numberBetween(100, 999));
    }
}