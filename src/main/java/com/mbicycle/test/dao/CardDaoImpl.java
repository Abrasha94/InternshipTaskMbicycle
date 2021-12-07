package com.mbicycle.test.dao;

import com.mbicycle.test.model.Card;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDaoImpl extends CommonDao<Card> implements CardDao {

    private static final String SELECT_BE_ID = "select * from main.cards where id = ?";

    private static final String ID_FIELD_NAME = "id";
    private static final String DISCOUNT_FIELD_NAME = "discount";

    @Override
    public Card findByDiscount(Integer discount) {
        //todo: realization
        return null;
    }

    @Override
    protected Card fillEntity(ResultSet resultSet) throws SQLException {
        Card card = new Card();
        card.setId(resultSet.getInt(ID_FIELD_NAME));
        card.setDiscount(resultSet.getInt(DISCOUNT_FIELD_NAME));
        return card;
    }

    @Override
    protected String getReadSQL() {
        return SELECT_BE_ID;
    }
}
