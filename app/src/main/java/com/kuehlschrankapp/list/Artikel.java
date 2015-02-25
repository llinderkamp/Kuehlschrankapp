package com.kuehlschrankapp.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Creed on 24.02.2015.
 */
public class Artikel {

    /**
     * ctor
     */
    public Artikel() {

    }

    /**
     * Erweiterter Ctor
     * @param a_itemDescription
     * @param a_amount
     * @param a_isFood
     */
    public Artikel( String a_itemDescription, int a_amount, boolean a_isFood, String aUnit ) {
        this.itemDescription = a_itemDescription;
        this.amount = a_amount;
        this.isFood = a_isFood;
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

    /**
     * Setzt die Einheiten in eine Liste
     */
    public void createUnitList(){
        unitList.add(0,"kg");
        unitList.add(1,"g");
        unitList.add(2,"mg");
        unitList.add(3,"l");
        unitList.add(4,"ml");
        unitList.add(5,"Stk");
        unitList.add(6,"Packung(en)");
        unitList.add(7,"Sack");
        unitList.add(8,"Schachtel(n)");
        unitList.add(9,"Flasche(n)");
        unitList.add(10,"Becher");
        unitList.add(11,"Tüte(n)");

    }



//===========================================================
// ATTRIBUTE
//===========================================================

    private String itemDescription;
    private int amount;
    private String unit;
    ArrayList<String> unitList = new ArrayList<String>();
    private boolean isFood = true;



}//Artikel
