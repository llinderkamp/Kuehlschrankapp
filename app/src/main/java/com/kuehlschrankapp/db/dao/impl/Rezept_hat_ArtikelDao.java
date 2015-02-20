package com.kuehlschrankapp.db.dao.impl;

import android.content.Context;

import com.kuehlschrankapp.db.dao.AbstractDao;
import com.kuehlschrankapp.db.dao.IDao;
import com.kuehlschrankapp.db.dto.impl.Rezept;
import com.kuehlschrankapp.db.dto.impl.Rezept_hat_Artikel;

import java.util.List;

/**
 * Created by laj on 17.02.2015.
 * Rezept_hat_ArtikelDao
 */
public class Rezept_hat_ArtikelDao extends AbstractDao<Rezept_hat_Artikel> implements IDao<Rezept_hat_Artikel> {

    public static Rezept_hat_ArtikelDao getInstance(Context context) {
        return new Rezept_hat_ArtikelDao(context);
    }

    private Rezept_hat_ArtikelDao(final Context context) {
        super(context, Rezept_hat_Artikel.class);
    }

    public List<Rezept_hat_Artikel> getAllArtikelFromRezept(Rezept rezept){
        return  getAllEntrysAsListWhereEq("rezept_id", rezept);
    }
}
