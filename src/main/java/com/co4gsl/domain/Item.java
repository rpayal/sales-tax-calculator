package com.co4gsl.domain;

import com.co4gsl.enums.ItemType;

import java.math.BigDecimal;

/**
 * Created by rpayal on 20/12/2016.
 */
public class Item {
    private String sku;
    private String name;
    private int qty;
    private BigDecimal itemPrice;
    private ItemType itemType;
    private BigDecimal itemPriceWithTax;
    private BigDecimal fixedTax;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getItemPriceWithTax() {
        return itemPriceWithTax == null ? BigDecimal.ZERO : itemPriceWithTax;
    }

    public void setItemPriceWithTax(BigDecimal itemPriceWithTax) {
        this.itemPriceWithTax = itemPriceWithTax;
    }

    public BigDecimal getFixedTax() {
        return fixedTax == null ? BigDecimal.ZERO : fixedTax;
    }

    public void setFixedTax(BigDecimal fixedTax) {
        this.fixedTax = fixedTax;
    }

    @Override
    public String toString(){
        return qty + " "+name+" : " + getItemPriceWithTax();
    }
}
