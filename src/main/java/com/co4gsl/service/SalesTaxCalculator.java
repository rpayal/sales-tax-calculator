package com.co4gsl.service;

import com.co4gsl.domain.Item;
import com.co4gsl.enums.ItemType;
import com.co4gsl.enums.TaxType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created by rpayal on 20/12/2016.
 */
public class SalesTaxCalculator implements ISalesTaxCalculator {
    @Override
    public BigDecimal calculateTax(Item item) {
        if (item.getItemType().isExempted()) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal taxAmt = TaxType.BASIC.getRate().multiply(item.getItemPrice().multiply(new BigDecimal(item.getQty())));
            if (! item.getFixedTax().equals(BigDecimal.ZERO)) {
                taxAmt = taxAmt.add(item.getFixedTax());
            }
            return roundOffTax(taxAmt);
        }
    }

    private BigDecimal roundOffTax(BigDecimal amt) {
        // To round to the nearest .05, multiply by 20, round to the nearest integer, then divide by 20
        BigDecimal result = new BigDecimal(Math.ceil(amt.doubleValue() * 20) / 20);

        return result.setScale(2, RoundingMode.HALF_UP);
    }

}
