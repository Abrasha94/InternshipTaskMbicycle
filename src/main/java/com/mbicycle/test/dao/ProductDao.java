package com.mbicycle.test.dao;

import com.mbicycle.test.model.Product;

public interface ProductDao extends EntityDao<Product> {

    Product findByName(String name);

}
