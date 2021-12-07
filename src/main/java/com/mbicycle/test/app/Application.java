package com.mbicycle.test.app;

import com.mbicycle.test.exception.ValidateException;
import com.mbicycle.test.service.Calculator;
import com.mbicycle.test.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {


    private static final Logger LOG = LogManager.getLogger(Application.class);

    public static void main(String... args) throws ValidateException {

        if (Valid.ProductValid(args[0])) {
            Calculator.INSTANCE.calculateCost(args[0]);
        } else {
            LOG.error("Invalid 1st argument");
            throw new ValidateException("Invalid argument = " + args[0]);
        }
        if (Valid.CardValid(args[1])) {
            Calculator.INSTANCE.calculateTotalPrice(args[1]);
        } else {
            LOG.error("Invalid 2nd argument");
            throw new ValidateException("Invalid argument = " + args[1]);
        }
    }
}
