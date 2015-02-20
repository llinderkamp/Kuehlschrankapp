package com.kuehlschrankapp.db.dao.impl;

import android.content.Context;

import com.kuehlschrankapp.db.dao.AbstractDao;
import com.kuehlschrankapp.db.dao.IDao;
import com.kuehlschrankapp.db.dto.impl.Einkaufsliste;

/**
 * Created by laj on 17.02.2015.
 * EinkaufslisteDao
 */
public class EinkaufslisteDao extends AbstractDao<Einkaufsliste> implements IDao<Einkaufsliste> {

    public static EinkaufslisteDao getInstance(Context context) {
        return new EinkaufslisteDao(context);
    }

    private EinkaufslisteDao(final Context context) {
        super(context, Einkaufsliste.class);
    }
}
