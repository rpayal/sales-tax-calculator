package com.co4gsl.enums;

import java.math.BigDecimal;

/**
 * Created by rpayal on 20/12/2016.
 */
public enum TaxType {
    BASIC(new BigDecimal("0.175"));

    private BigDecimal rate;

    TaxType(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
