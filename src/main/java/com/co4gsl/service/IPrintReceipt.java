package com.co4gsl.service;

import com.co4gsl.domain.Receipt;

/**
 * Created by rpayal on 20/12/2016.
 */
public interface IPrintReceipt {
    String calculateAndPrintReceiptWithTax(Receipt receipt);
}
