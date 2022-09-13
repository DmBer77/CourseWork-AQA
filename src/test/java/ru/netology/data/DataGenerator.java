package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    public DataGenerator() {
    }

    static Faker faker = new Faker((new Locale("ru")));

    public static String getCardNumber(int id) {
//        String cardNumber;
        String[] ArrayOfCardNumbers = {"5500 1122 3344 5566",
                "2223 1234 5678 9001",
                "2145 7896 3214 0001"};
        Random random = new Random();
        if (id == 1) {
            return "1111 2222 3333 4444";
            }
            if (id == 2) {
                return "5555 6666 7777 8888";
            } else {
                return ArrayOfCardNumbers[random.nextInt(ArrayOfCardNumbers.length)];
            }
    }

    public static String generateMonth() {
        int month = faker.number().numberBetween(1, 12);
        String res = null;
        if (month < 10) {
            res = "0" + month;
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

//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class CardInfo {
//        private String month;
//        private String year;
//        private String holder;
//        private String code;
//
//    }
}