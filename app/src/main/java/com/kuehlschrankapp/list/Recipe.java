package com.kuehlschrankapp.list;

import java.util.ArrayList;

/**
 * Created by Creed on 24.02.2015.
 * Diese Klasse beinhaltet alle Funktionen für ein Rezept
 */
public class Recipe extends Liste {


    private String name;
    private String preparation;
    private int portion;


    /**
     * ctor
     */
    public  Recipe(){

    }

    /**
     * Erweiterter Ctor
     * @param name
     * @param preparation
     * @param portion
     * @param ownRecipe
     */
    public  Recipe( String name, String preparation, int portion, boolean ownRecipe )
    {
        this.name = name;
        this.preparation = preparation;
        this.portion = portion;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }


    /**
     * Erstellt ein Rezept
     */
    @Override
    public void createList(){


    }

    /**
     * Lädt ein Rezept
     */
    @Override
    public void loadList() {

    }

    /**
     * Bearbeitet ein Rezept
     */
    @Override
    public void updateList() {

    }










}
