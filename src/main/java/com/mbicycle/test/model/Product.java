package com.mbicycle.test.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Entity {

    private int id;
    private int availability;
    private BigDecimal price;
    private String name;

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
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
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && availability == product.availability && Objects.equals(price, product.price)
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availability, price, name);
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
