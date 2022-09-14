package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLHelper {

    private static final QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static void setDataToDB(String id, String status) {
        var dataSQL = "INSERT INTO payment_entity(id, status) VALUES (?, ?);";
        try (
                var conn = getConn();
        ) {
            runner.update(conn, dataSQL, id, status);
        }
    }

    @SneakyThrows
    public static void getResponseFromDB() {
        var cardsSQL = "SELECT id, status FROM payment_entity;";
        try (
                var conn = getConn()
        ) {
            var result = runner.query(conn, cardsSQL, new BeanHandler<>(Cards.class));
            System.out.println(result);
        }
    }
    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
    }

//    @BeforeEach

//    @SneakyThrows
//    public static void setRequestDataForCardOne() {
//        var dataSQL = "INSERT INTO card(cardNumber, cardMonth, cardYear, cardHolder, cardCode) VALUES (?, ?, ?, ?, ?);";
//        try (
//                var conn = getConn();
//        ) {
//            runner.update(conn, dataSQL, DataGenerator.getCardNumber(1), DataGenerator.generateMonth(), DataGenerator.generateYear(),
//                DataGenerator.generateHolder("en"), DataGenerator.generateCode());
//        }
//    }


//
//    @SneakyThrows
//    public static void setRequestDataForCardTwo() {
//        var dataSQL = "INSERT INTO card(cardNumber, cardMonth, cardYear, cardHolder, cardCode) VALUES (?, ?, ?, ?, ?);";
//        try (
//                var conn = getConn();
//        ) {
//            runner.update(conn, dataSQL, DataGenerator.getCardNumber(2), DataGenerator.generateMonth(), DataGenerator.generateYear(),
//                    DataGenerator.generateHolder("en"), DataGenerator.generateCode());
//        }
//    }



//    @SneakyThrows
//    public static void setRequestDataForCardOne() {
//        var dataSQL = "INSERT INTO card(cardNumber, cardMonth, cardYear, cardHolder, cardCode) VALUES (?, ?, ?, ?, ?);";
//        try (
//                var conn = getConn();
//                var dataStmt = conn.prepareStatement(dataSQL);
//        ) {
//            dataStmt.setString(1, DataGenerator.getCardNumber(1));
//            dataStmt.setString(2, DataGenerator.generateMonth());
//            dataStmt.setString(3, DataGenerator.generateYear());
//            dataStmt.setString(4, DataGenerator.generateHolder("en"));
//            dataStmt.setString(5, DataGenerator.generateCode());
//            dataStmt.executeUpdate();
//        }
//    }

//    @SneakyThrows
//    public static void setRequestDataForCardTwo() {
//        var dataSQL = "INSERT INTO card(cardNumber, cardMonth, cardYear, cardHolder, cardCode) VALUES (?, ?, ?, ?, ?);";
//        try (
//                var conn = getConn();
//                var dataStmt = conn.prepareStatement(dataSQL);
//        ) {
//            dataStmt.setString(1, DataGenerator.getCardNumber(2));
//            dataStmt.setString(2, DataGenerator.generateMonth());
//            dataStmt.setString(3, DataGenerator.generateYear());
//            dataStmt.setString(4, DataGenerator.generateHolder("en"));
//            dataStmt.setString(5, DataGenerator.generateCode());
//            dataStmt.executeUpdate();
//        }
//    }

//        // Пример чтения данных
////        @Test
//    @SneakyThrows
//    public static void getResponseFromServer() {
////        var countSQL = "SELECT COUNT(*) FROM card;";
//        var cardsSQL = "SELECT id, status FROM card;";
//        try (
//                var conn = getConn();
//                var countStmt = conn.createStatement();
//                var cardsStmt = conn.prepareStatement(cardsSQL);
//        ) {
////            try (var rs = countStmt.executeQuery(countSQL)) {
////                if (rs.next()) {
////// выборка значения по индексу столбца (нумерация с 1) — лучше выбирать по имени
////                    var count = rs.getInt(1);
////// TODO: использовать
////                    System.out.println(count);
////                }
////            }
//            cardsStmt.setInt(1, 1);
//            try (var rs = cardsStmt.executeQuery()) {
//                while (rs.next()) {
//                    var id = rs.getString("id");
//                    var status = rs.getString("status");
//
//// TODO: сложить всё в список
//                }
//            }
//        }
//    }



}
