package com.co4gsl.service;

import com.co4gsl.domain.Item;
import com.co4gsl.enums.ItemType;
import com.co4gsl.helper.TestHelper;
import com.co4gsl.service.ISalesTaxCalculator;
import com.co4gsl.service.SalesTaxCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by rpayal on 20/12/2016.
 */
@RunWith(Parameterized.class)
public class SalesTaxCalculatorTest {
    private String sku;
    private String name;
    private int qty;
    private BigDecimal itemPrice;
    private ItemType itemType;
    private BigDecimal itemPriceWithTax;
    private BigDecimal fixedTax;

    private ISalesTaxCalculator salesTaxCalculator;

    public SalesTaxCalculatorTest(String sku, String name, int qty, BigDecimal itemPrice , ItemType type , BigDecimal fixedTax, BigDecimal expectedPriceWithTax){
        this.sku = sku;
        this.name = name;
        this.qty = qty;
        this.itemPrice = itemPrice;
        this.itemType = type;
        this.fixedTax = fixedTax;
        this.itemPriceWithTax = expectedPriceWithTax;
    }

    @Before
    public void setup() {
        salesTaxCalculator = new SalesTaxCalculator();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> holder = new ArrayList<>();
        Collections.addAll(holder, TestHelper.INPUT1_ITEM_LIST);
        Collections.addAll(holder, TestHelper.INPUT2_ITEM_LIST);
        return Arrays.asList(holder.toArray(new Object[holder.size()][]));
    }

    @Test
    public void testItemPriceWithTax(){
        Item item = TestHelper.createItem(sku, name, qty, itemPrice, itemType, fixedTax);
        item.setItemPriceWithTax(item.getItemPrice().add(salesTaxCalculator.calculateTax(item)));
        Assert.assertEquals(itemPriceWithTax, item.getItemPriceWithTax());
    }
}