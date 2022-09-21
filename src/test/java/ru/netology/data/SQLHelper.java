package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {

    private static final QueryRunner runner = new QueryRunner();

    public SQLHelper() {
    }

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public int getCountOfApprovedCredit() {
        var countApprovedCreditSQL = "SELECT count(id) FROM credit_request_entity WHERE status = 'APPROVED';";
        Number result = 0;
        try (
                var conn = getConn()
        ) {
            result = runner.query(conn, countApprovedCreditSQL, new ScalarHandler<>());
        }
        return result.intValue();
    }

    @SneakyThrows
    public int getCountOfDeclinedPayment() {
        var countDeclinedPaymentSQL = "SELECT count(id) FROM payment_entity WHERE status = 'DECLINED';";
        Number result = 0;
        try (
                var conn = getConn()
        ) {
            result = runner.query(conn, countDeclinedPaymentSQL, new ScalarHandler<>());
        }
        return result.intValue();
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConn();
        runner.execute(conn, "DELETE FROM credit_request_entity");
        runner.execute(conn, "DELETE FROM order_entity");
        runner.execute(conn, "DELETE FROM payment_entity");
    }
}
