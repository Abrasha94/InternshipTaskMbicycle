package com.mbicycle.test.dao;

import com.mbicycle.test.model.Card;

public interface CardDao extends EntityDao<Card> {

    Card findByDiscount(Integer discount);
}
