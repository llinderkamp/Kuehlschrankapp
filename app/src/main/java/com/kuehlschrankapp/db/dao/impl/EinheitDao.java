package com.kuehlschrankapp.db.dao.impl;

import android.content.Context;

import com.kuehlschrankapp.db.dao.AbstractDao;
import com.kuehlschrankapp.db.dao.IDao;
import com.kuehlschrankapp.db.dto.impl.Einheit;

/**
 * Created by laj on 17.02.2015.
 * EinheitDao
 */
public class EinheitDao extends AbstractDao<Einheit> implements IDao<Einheit> {

    public static EinheitDao getInstance(Context context) {
        return new EinheitDao(context);
    }

    private EinheitDao(final Context context) {
        super(context, Einheit.class);
    }


}
