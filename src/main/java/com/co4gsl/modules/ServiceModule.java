package com.co4gsl.modules;

import com.co4gsl.domain.Item;
import com.co4gsl.domain.Receipt;
import com.co4gsl.service.IPrintReceipt;
import com.co4gsl.service.ISalesTaxCalculator;
import com.co4gsl.service.PrintReceipt;
import com.co4gsl.service.SalesTaxCalculator;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by rpayal on 20/12/2016.
 */
public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ISalesTaxCalculator.class).to(SalesTaxCalculator.class).in(Singleton.class);
        bind(IPrintReceipt.class).to(PrintReceipt.class).in(Singleton.class);
        bind(Item.class);
        bind(Receipt.class);
    }
}
