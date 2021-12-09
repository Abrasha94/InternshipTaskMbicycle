package com.mbicycle.test.dao;

import com.mbicycle.test.model.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.mbicycle.test.service.DataBaseService.*;

public abstract class CommonDao<T extends Entity> implements EntityDao<T> {

    private static final Logger LOG = LogManager.getLogger(CommonDao.class);

    protected Connection connection;

    @Override
    public T readById(Integer id) {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (final PreparedStatement preparedStatement = connection.prepareStatement(getReadSQL())) {
            preparedStatement.setInt(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return fillEntity(resultSet);
                } else LOG.error("Id = {} do not found", id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract T fillEntity(ResultSet resultSet) throws SQLException;

    protected abstract String getReadSQL();
}
