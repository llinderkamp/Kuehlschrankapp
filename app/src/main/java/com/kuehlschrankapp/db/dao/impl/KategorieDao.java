package com.kuehlschrankapp.db.dao.impl;

import android.content.Context;

import com.kuehlschrankapp.db.dao.AbstractDao;
import com.kuehlschrankapp.db.dao.IDao;
import com.kuehlschrankapp.db.dto.impl.Kategorie;

/**
 * Created by laj on 17.02.2015.
 * KategorieDao
 */
public class KategorieDao extends AbstractDao<Kategorie> implements IDao<Kategorie> {

    public static KategorieDao getInstance(Context context) {
        return new KategorieDao(context);
    }

    private KategorieDao(final Context context) {
        super(context, Kategorie.class);
    }
}
