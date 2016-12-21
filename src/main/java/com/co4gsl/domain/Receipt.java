package com.co4gsl.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rpayal on 20/12/2016.
 */
public class Receipt {
    private List<Item> itemList;
    private BigDecimal saleTax = BigDecimal.ZERO;
    private BigDecimal totalCost = BigDecimal.ZERO;

    public Receipt() {
        itemList = new ArrayList<Item>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItemToRecipt(Item item) {
        itemList.add(item);
    }

    public BigDecimal getSaleTax() {
        return saleTax;
    }

    public void setSaleTax(BigDecimal saleTax) {
        this.saleTax = saleTax;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Item item : itemList) {
            buffer.append("\n").append(item.toString());
        }
        buffer.append("\nSales Taxes : " + saleTax);
        buffer.append("\nTotal : " + totalCost);

        return buffer.toString();
    }
}
