package com.mbicycle.test.dao;

import com.mbicycle.test.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl extends CommonDao<Product> implements ProductDao {

    private static final String SELECT_BY_ID = "select * from products where id = ?";

    private static final String PRICE_FIELD_NAME = "price";
    private static final String AVAILABILITY_FIELD_NAME = "availability";
    private static final String NAME_FIELD_NAME = "name";

    @Override
    protected Product fillEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setPrice(resultSet.getBigDecimal(PRICE_FIELD_NAME));
        product.setAvailability(resultSet.getInt(AVAILABILITY_FIELD_NAME));
        product.setName(resultSet.getString(NAME_FIELD_NAME));
        return product;
    }

    @Override
    protected String getReadSQL() {
        return SELECT_BY_ID;
    }

}
