package com.mbicycle.test.dao;

import com.mbicycle.test.model.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public abstract class CommonDao<T extends Entity> implements EntityDao<T> {

    private static final Logger LOG = LogManager.getLogger(CommonDao.class);

    private static final String ID_FIELD_NAME = "id";

    protected Connection connection;

    @Override
    public T create(T entity) {
        //todo: realization
        return null;
    }

    @Override
    public T readById(Integer id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "root");
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


    @Override
    public T update(T entity) {
        // TODO: realization
        return null;
    }

    @Override
    public void delete(Integer id) {
        // TODO: realization
    }

    protected abstract T fillEntity(ResultSet resultSet) throws SQLException;

    protected abstract String getReadSQL();
}
