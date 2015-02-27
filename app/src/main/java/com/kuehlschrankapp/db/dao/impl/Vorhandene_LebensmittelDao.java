package com.kuehlschrankapp.db.dao.impl;

import android.content.Context;

import com.kuehlschrankapp.db.dao.AbstractDao;
import com.kuehlschrankapp.db.dao.IDao;
import com.kuehlschrankapp.db.dto.impl.Vorhandene_Lebensmittel;

import java.util.List;

/**
 * Created by laj on 17.02.2015.
 * Vorhandene_LebensmittelDao
 */
public class Vorhandene_LebensmittelDao extends AbstractDao<Vorhandene_Lebensmittel> implements IDao<Vorhandene_Lebensmittel> {

    public static Vorhandene_LebensmittelDao getInstance(Context context) {
        return new Vorhandene_LebensmittelDao(context);
    }

    public List<Vorhandene_Lebensmittel> getFavoriteArtikel() {
        return getAllEntrysAsListWhereEq("favorit", Boolean.valueOf(true));
    }

    private Vorhandene_LebensmittelDao(final Context context) {
        super(context, Vorhandene_Lebensmittel.class);
    }
}
