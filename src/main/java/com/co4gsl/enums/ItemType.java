package com.co4gsl.enums;

/**
 * Created by rpayal on 20/12/2016.
 */
public enum ItemType {
    OTHERS(false), FOOD(false), MEDICAL(true), BOOK(false);

    private boolean isExempted;

    private ItemType(boolean exepmted) {
        this.isExempted = exepmted;
    }

    public boolean isExempted(){
        return isExempted;
    }
}
