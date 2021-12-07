package com.mbicycle.test.validation;

public class Valid {

    private static final String PRODUCT_REGEX = "(\\d+-\\d+,\\s)*\\d+-\\d+";
    private static final String CARD_REGEX = "card-\\d+";

    public static boolean ProductValid(String argument) {
        return argument.matches(PRODUCT_REGEX);
    }

    public static boolean CardValid(String argument) {
        return argument.matches(CARD_REGEX);
    }


}
