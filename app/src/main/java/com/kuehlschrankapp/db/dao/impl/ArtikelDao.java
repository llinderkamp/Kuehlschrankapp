package com.kuehlschrankapp.db.dao.impl;

import android.content.Context;

import com.kuehlschrankapp.db.dao.AbstractDao;
import com.kuehlschrankapp.db.dao.IDao;
import com.kuehlschrankapp.db.dto.impl.Artikel;
import com.kuehlschrankapp.db.dto.impl.Kategorie;

import java.util.List;

/**
 * Created by laj on 17.02.2015.
 * ArtikelDao
 */
public class ArtikelDao extends AbstractDao<Artikel> implements IDao<Artikel> {

    public static ArtikelDao getInstance(Context context) {
        return new ArtikelDao(context);
    }

    private ArtikelDao(final Context context) {
        super(context, Artikel.class);
    }


    public List<Artikel> getAllEntrysAsListFromSpecificKategorie(Kategorie kategorie){
        return  getAllEntrysAsListWhereEq("kategorie_id", kategorie);
    }

    public List<Artikel> getAllNichtLebensmittel(){
        return  getAllEntrysAsListWhereEq("istLebensmittel", Boolean.valueOf(false));
    }
}
