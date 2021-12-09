package com.mbicycle.test.dao;

import com.mbicycle.test.model.Card;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDaoImpl extends CommonDao<Card> implements CardDao {

    private static final String SELECT_BE_ID = "select * from cards where id = ?";

    private static final String DISCOUNT_FIELD_NAME = "discount";

    @Override
    protected Card fillEntity(ResultSet resultSet) throws SQLException {
        Card card = new Card();
        card.setDiscount(resultSet.getInt(DISCOUNT_FIELD_NAME));
        return card;
    }

    @Override
    protected String getReadSQL() {
        return SELECT_BE_ID;
    }
}
