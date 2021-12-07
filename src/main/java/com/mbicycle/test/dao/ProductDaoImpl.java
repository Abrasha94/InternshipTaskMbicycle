package com.mbicycle.test.dao;

import com.mbicycle.test.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl extends CommonDao<Product> implements ProductDao {

    private static final String SELECT_BY_ID = "select * from main.products where id = ?";

    private static final String ID_FIELD_NAME = "id";
    private static final String PRICE_FIELD_NAME = "price";
    private static final String AVAILABILITY_FIELD_NAME = "availability";
    private static final String NAME_FIELD_NAME = "name";
    private static final String SELECT_BY_NAME = "select * from main.products where name = ?";

    @Override
    protected Product fillEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt(ID_FIELD_NAME));
        product.setPrice(resultSet.getBigDecimal(PRICE_FIELD_NAME));
        product.setAvailability(resultSet.getInt(AVAILABILITY_FIELD_NAME));
        product.setName(resultSet.getString(NAME_FIELD_NAME));
        return product;
    }

    @Override
    protected String getReadSQL() {
        return SELECT_BY_ID;
    }

    @Override
    public Product findByName(String name) {
        // TODO: realization
        return null;
    }
}
