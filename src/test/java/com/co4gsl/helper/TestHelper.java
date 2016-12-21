package com.co4gsl.helper;

import com.co4gsl.InjectorFactory;
import com.co4gsl.domain.Item;
import com.co4gsl.enums.ItemType;

import java.math.BigDecimal;

/**
 * Created by rpayal on 20/12/2016.
 */
public class TestHelper {
    /**
     * Data set
     */
    public static Object[][] INPUT1_ITEM_LIST = new Object[][]{
            {"sku1", "book", 1, new BigDecimal("29.49"), ItemType.BOOK, BigDecimal.ZERO, new BigDecimal("34.69")},
            {"sku2", "music CD", 1, new BigDecimal("15.99"), ItemType.OTHERS, new BigDecimal("1.25"), new BigDecimal("20.04")},
            {"sku3", "chocolate snack", 1, new BigDecimal("0.75"), ItemType.FOOD, BigDecimal.ZERO, new BigDecimal("0.90")}
    };

    public static Object[][] INPUT2_ITEM_LIST = new Object[][]{
            {"sku4", "bottle of wine", 1, new BigDecimal("20.99"), ItemType.BOOK, BigDecimal.ZERO, new BigDecimal("24.69")},
            {"sku5", "box of tooth ache pills", 1, new BigDecimal("4.15"), ItemType.MEDICAL, BigDecimal.ZERO, new BigDecimal("4.15")},
            {"sku6", "box of pins", 1, new BigDecimal("11.25"), ItemType.OTHERS, BigDecimal.ZERO, new BigDecimal("13.25")},
            {"sku7", "music CD", 1, new BigDecimal("14.99"), ItemType.FOOD, new BigDecimal("1.25"), new BigDecimal("18.89")}
    };

    /**
     * Helper method to create Item
     *
     * @param sku
     * @param name
     * @param qty
     * @param price
     * @param itemType
     * @param fixedTax
     * @return
     */
    public static Item createItem(String sku, String name, int qty, BigDecimal price, ItemType itemType, BigDecimal fixedTax) {
        Item item = InjectorFactory.getInjector().getInstance(Item.class);
        item.setSku(sku);
        item.setName(name);
        item.setQty(qty);
        item.setItemType(itemType);
        item.setItemPrice(price);
        item.setFixedTax(fixedTax);

        return item;
    }
}
