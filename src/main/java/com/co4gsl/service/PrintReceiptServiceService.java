package com.co4gsl.service;

import com.co4gsl.domain.Item;
import com.co4gsl.domain.Receipt;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by rpayal on 20/12/2016.
 */
public class PrintReceiptServiceService implements IPrintReceiptService {
    private final ISalesTaxCalculator salesTaxCalculator;

    @Inject
    public PrintReceiptServiceService(ISalesTaxCalculator salesTaxCalculator) {
        this.salesTaxCalculator = salesTaxCalculator;
    }

    @Override
    public String calculateAndPrintReceiptWithTax(Receipt receipt) {
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Item item : receipt.getItemList()) {
            BigDecimal tax = salesTaxCalculator.calculateTax(item);
            totalTax = totalTax.add(tax);
            totalCost = totalCost.add(item.getItemPrice().add(tax));

            item.setItemPriceWithTax(item.getItemPrice().add(tax));
        }
        receipt.setSaleTax(totalTax);
        receipt.setTotalCost(totalCost);
        return receipt.toString();
    }
}
