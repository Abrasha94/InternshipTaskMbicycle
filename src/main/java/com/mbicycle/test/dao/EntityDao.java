package com.mbicycle.test.dao;

import com.mbicycle.test.model.Entity;

public interface EntityDao<T extends Entity> {

    T create(T entity);

    T readById(Integer id);

    T update(T entity);

    void delete(Integer id);

}
