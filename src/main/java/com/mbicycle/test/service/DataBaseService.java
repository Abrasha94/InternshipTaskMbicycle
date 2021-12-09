package com.mbicycle.test.service;

import com.mbicycle.test.app.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;

import static java.lang.String.*;

public class DataBaseService {

    private static final Logger LOG = LogManager.getLogger(Application.class);

    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "";

    private static final String CREATE_CARDS_TABLE = "create table cards(id int primary key, discount int)";
    private static final String CREATE_PRODUCTS_TABLE = "create table products(id int primary key, availability int, " +
            "price decimal(10, 2), name varchar(100))";

    public static void createDB() {

        try {
            try (Connection dbConnection = getDBConnection()) {
                dbConnection.setAutoCommit(false);
                Statement statement = getDBConnection().createStatement();
                statement.execute(CREATE_CARDS_TABLE);
                statement.execute(CREATE_PRODUCTS_TABLE);
                statement.close();
                dbConnection.commit();
            }
        } catch (SQLException e) {
            LOG.error("Error when created database");
        }
    }

    public static void fillDB() {

        try (Connection dbConnection = getDBConnection()) {
            dbConnection.setAutoCommit(false);
            Statement statement = dbConnection.createStatement();
            statement.execute(getSqlForCards(1, 10));
            statement.execute(getSqlForCards(2, 13));
            statement.execute(getSqlForCards(3, 20));
            statement.execute(getSqlForCards(666, 5));
            statement.execute(getSqlForCards(12345, 25));
            statement.execute(getSqlForProducts(1, 20, BigDecimal.valueOf(1.4), "'bread'"));
            statement.execute(getSqlForProducts(2, 5, BigDecimal.valueOf(2.4), "'milk'"));
            statement.execute(getSqlForProducts(3, 0, BigDecimal.valueOf(5.0), "'cheese'"));
            statement.execute(getSqlForProducts(21, 2, BigDecimal.valueOf(1000.79), "'TV'"));
            statement.close();
            dbConnection.commit();
        } catch (SQLException e) {
            LOG.error("Error when fill database");
        }
    }

    private static String getSqlForProducts(Integer id, Integer availability, BigDecimal price, String name) {
        return format("insert into products(id, availability, price, name) values (%d, %d, %s, %s)", id, availability, price, name);
    }

    private static String getSqlForCards(Integer id, Integer discount) {
        return format("insert into cards(id, discount) values (%d, %d)", id, discount);
    }

    private static Connection getDBConnection() {
            Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
