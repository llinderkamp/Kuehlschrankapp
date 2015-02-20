package com.kuehlschrankapp.db.dao.impl;

import android.content.Context;

import com.kuehlschrankapp.db.dao.AbstractDao;
import com.kuehlschrankapp.db.dao.IDao;
import com.kuehlschrankapp.db.dto.impl.Rezept;

/**
 * Created by laj on 17.02.2015.
 * RezeptDAO
 */
public class RezepteDao extends AbstractDao<Rezept> implements IDao<Rezept> {

    public static RezepteDao getInstance(Context context) {
        return new RezepteDao(context);
    }

    private RezepteDao(final Context context) {
        super(context, Rezept.class);
    }
}
