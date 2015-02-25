package com.kuehlschrankapp.list;

import java.util.ArrayList;

/**
 * Created by Creed on 24.02.2015.
 * Dies ist die Basisklasse für die Einkaufsliste und Rezept
 */
public abstract class Liste {


    /**
     * erstellt eine Liste
     */
    public abstract void createList();

    /**
     * lädt eine Liste
     */
    public abstract void loadList();

    /**
     * bearbeitet eine Liste
     */
    public abstract void updateList();

    //public ArrayList<Artikel> artikelList = new ArrayList<Artikel>();

}//Liste
