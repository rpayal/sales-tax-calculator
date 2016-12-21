package com.co4gsl.service;

import com.co4gsl.domain.Item;

import java.math.BigDecimal;

/**
 * Created by rpayal on 20/12/2016.
 */
public interface ISalesTaxCalculator {
    BigDecimal calculateTax(Item item);
}
