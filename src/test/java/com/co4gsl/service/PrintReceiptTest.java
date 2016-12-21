package com.co4gsl.service;

import com.co4gsl.InjectorFactory;
import com.co4gsl.domain.Item;
import com.co4gsl.domain.Receipt;
import com.co4gsl.enums.ItemType;
import com.co4gsl.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.co4gsl.helper.TestHelper.INPUT1_ITEM_LIST;
import static com.co4gsl.helper.TestHelper.INPUT2_ITEM_LIST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rpayal on 20/12/2016.
 */
@RunWith(Parameterized.class)
public class PrintReceiptTest {
    private List<Item> itemList;
    private BigDecimal saleTax = BigDecimal.ZERO;
    private BigDecimal totalCost = BigDecimal.ZERO;

    private IPrintReceipt printReceipt;

    public PrintReceiptTest(List<Item> itemList, BigDecimal saleTax, BigDecimal totalCost) {
        this.itemList = itemList;
        this.saleTax = saleTax;
        this.totalCost = totalCost;
    }

    @Before
    public void setup() {
        printReceipt = InjectorFactory.getInjector().getInstance(IPrintReceipt.class);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {createItemList(INPUT1_ITEM_LIST), new BigDecimal("9.40"), new BigDecimal("55.63")},
                {createItemList(INPUT2_ITEM_LIST), new BigDecimal("9.60"), new BigDecimal("60.98")}};
        return Arrays.asList(data);
    }

    @Test
    public void testCartCostAndTax() {
        Receipt receipt = InjectorFactory.getInjector().getInstance(Receipt.class);
        for (Item item : itemList) {
            receipt.addItemToRecipt(item);
        }
        String resultReceipt = printReceipt.calculateAndPrintReceiptWithTax(receipt);
        //System.out.println(resultReceipt);
        assertNotNull(resultReceipt);
        assertEquals(resultReceipt, receipt.toString());
        assertEquals(receipt.getSaleTax(), saleTax);
        assertEquals(receipt.getTotalCost(), totalCost);
    }

    private static List<Item> createItemList(Object[][] data) {
        List<Item> list = new ArrayList<Item>();
        for (Object[] item : data) {
            list.add(TestHelper.createItem((String) item[0], (String) item[1], (Integer) item[2], (BigDecimal) item[3], (ItemType) item[4], (BigDecimal) item[5]));
        }
        return list;
    }
}