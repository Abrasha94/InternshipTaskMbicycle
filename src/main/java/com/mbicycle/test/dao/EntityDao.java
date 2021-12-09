package com.mbicycle.test.dao;

import com.mbicycle.test.model.Entity;

public interface EntityDao<T extends Entity> {

    T readById(Integer id);

}
