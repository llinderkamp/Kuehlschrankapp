package com.kuehlschrankapp.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Creed on 24.02.2015.
 */
public class Article {

    private String itemDescription;
    private int amount;
    private String unit;
    private boolean isFood = true;
    private String type;


    /**
     * ctor
     */
    public Article() {

    }

    public Article( String itemDescription, int amount, boolean isFood, String type){
        this.itemDescription = itemDescription;
        this.amount = amount;
        this.isFood = isFood;
        this.type = type;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean isFood) {
        this.isFood = isFood;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }





}
