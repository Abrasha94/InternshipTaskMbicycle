package com.mbicycle.test.model;

import java.math.BigDecimal;


public class Product implements Entity {

    private Integer id;
    private Integer availability;
    private BigDecimal price;
    private String name;

    public Product() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", availability=" + availability +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
