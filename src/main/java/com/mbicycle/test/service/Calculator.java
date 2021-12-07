package com.mbicycle.test.service;

import com.mbicycle.test.dao.CardDaoImpl;
import com.mbicycle.test.dao.EntityDao;
import com.mbicycle.test.dao.ProductDaoImpl;
import com.mbicycle.test.model.Card;
import com.mbicycle.test.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public enum Calculator {
    INSTANCE;

    private static final Logger LOG = LogManager.getLogger(Calculator.class);

    private static final String SPLIT_ARGUMENT = "-";
    private static final String SPLIT_PURCHASE_INFO = ", ";

    private BigDecimal totalPrice = BigDecimal.ZERO;

    private final EntityDao<Product> productDao = new ProductDaoImpl();
    private final EntityDao<Card> cardDao = new CardDaoImpl();

    public void calculateCost(String argument) {

        final String[] split = argument.split(SPLIT_PURCHASE_INFO);
        for (String s : split) {
            final Integer id = new Integer(s.split(SPLIT_ARGUMENT)[0]);
            final Product product = productDao.readById(id);
            int amount = new Integer(s.split(SPLIT_ARGUMENT)[1]);
            if (product.getAvailability() < amount) {
                amount = product.getAvailability();
                LOG.warn("Not enough product: " + product.getName());
            }
            BigDecimal total = product.getPrice().multiply(new BigDecimal(amount));
            totalPrice = totalPrice.add(total);
            LOG.info("Product: " + product.getName() + "---Price: " + product.getPrice().toString() + " x " + amount
                    + "---Total: " + total);
        }
    }

    public void calculateTotalPrice(String argument) {
        final Integer cardId = Integer.valueOf(argument.split(SPLIT_ARGUMENT)[1]);
        final Card card = cardDao.readById(cardId);
        if (card != null) {
            final int discount = card.getDiscount();
            totalPrice = totalPrice.subtract(totalPrice.multiply(new BigDecimal(discount))
                    .divide(BigDecimal.valueOf(100)));
            LOG.warn("Discount: " + discount + "%");
        }
        LOG.info("Total price: " + totalPrice);
    }

}
