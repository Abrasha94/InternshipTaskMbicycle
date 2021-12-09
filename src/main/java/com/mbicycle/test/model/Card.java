package com.mbicycle.test.model;


public class Card implements Entity {

    private Integer id;
    private Integer discount;

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", discount=" + discount +
                '}';
    }
}
