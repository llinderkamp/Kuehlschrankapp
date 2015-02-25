package com.kuehlschrankapp.list;

import java.util.ArrayList;

/**
 * Created by Creed on 24.02.2015.
 * Diese Klasse beinhaltet alle Funktionen für ein Rezept
 */
public class Recipe extends Liste {

    /**
     * ctor
     */
    public  Recipe(){

    }

    /**
     * Erweiterter Ctor
     * @param aName
     * @param aPreparation
     * @param aPortion
     * @param aOwnRecipe
     */
    public  Recipe( String aName, String aPreparation, int aPortion, boolean aOwnRecipe )
    {
        this.name = aName;
        this.preparation = aPreparation;
        this.portion = aPortion;
        this.ownRecipe = aOwnRecipe;

    }

    /**
     * Erstellt ein Rezept
     */
    @Override
    public void createList(){

        recipeList.add(this);
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

    public boolean isOwnRecipe() {
        return ownRecipe;
    }

    public void setOwnRecipe(boolean ownRecipe) {
        this.ownRecipe = ownRecipe;
    }

//===================================================
//  ATTRIBUTE
//===================================================
    private String name;
    private String preparation;
    private int portion;
    private boolean ownRecipe;

    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    Artikel art;





}//Recipe
