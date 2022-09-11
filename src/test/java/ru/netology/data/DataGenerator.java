package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {

    }

    static Faker faker = new Faker((new Locale("ru")));

//    public static String generateDate(int daysToAdd) {
//        return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//    }

    //    public static String generateCity(String locale) {
//        String[] ArrayOfCities = {"Абакан", "Владикавказ", "Екатеринбург", "Йошкар-Ола", "Казань", "Калининград",
//                "Калуга", "Краснодар", "Красноярск", "Курган", "Махачкала", "Москва", "Петропавловск-Камчатский",
//                "Сыктывкар", "Чебоксары", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Абакан", "Владимир",
//                "Нарьян-Мар", "Салехард", "Абакан", "Самара", "Санкт-Петербург", "Абакан", "Ставрополь", "Хабаровск"};
//
//        Random random = new Random();
//        int i = random.nextInt(ArrayOfCities.length);
//        return ArrayOfCities[i];
//    }
    public static String getCardNumber(int id) {
        String cardNumber;
        String[] ArrayOfCardNumbers = {"5500 1122 3344 5566",
                "2223 1234 5678 9001",
                "2145 7896 3214 0001"};
        Random random = new Random();
        if (id == 1) {
            cardNumber = "1111 2222 3333 4444";
        }
        if (id == 2) {
            cardNumber = "5555 6666 7777 8888";
        } else {
            cardNumber = ArrayOfCardNumbers[random.nextInt(ArrayOfCardNumbers.length)];
        }
        return cardNumber;
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
        return String.valueOf(faker.number().numberBetween(yearStart, yearFinish)).substring(2, 3);
    }

    public static String generateHolder(String locale) {
        return faker.name().fullName().toUpperCase();
    }

    public static String generateCode() {
        return String.valueOf(faker.number().numberBetween(100, 999));
    }
//
//    public static class Registration {
//        private Registration() {
//        }
//
//        public static UserInfo generateUser(String locale) {
//            return new UserInfo(
//                    generateCity("ru"),
//                    generateName("ru"),
//                    generatePhone("ru")
//            );
//        }
//    }
//
//    @Value
//    public static class UserInfo {
//        String city;
//        String name;
//        String phone;
//    }
}