package com.kuehlschrankapp.logic;

import android.content.Context;

import com.kuehlschrankapp.db.dao.impl.EinheitDao;
import com.kuehlschrankapp.db.dao.impl.KategorieDao;
import com.kuehlschrankapp.db.dto.impl.Einheit;
import com.kuehlschrankapp.db.dto.impl.Kategorie;

import java.util.List;

/**
 * Created by laj on 27.02.2015.
 * Logik für die Einheiten und die Kategorien
 */
public class CategoryUnitLogic {
    /**
     * Holt alle Einheiten
     *
     * @param context Context der Activity
     * @return Alle Einheiten als Liste
     */
    public List<Einheit> getAllUnits(Context context) {
        return EinheitDao.getInstance(context).getAllEntriesAsList();
    }

    /**
     * Holt alle Kategorien
     *
     * @param context Context der Activity
     * @return Alle Kategorien als Liste
     */
    public List<Kategorie> getAllCategories(Context context) {
        return KategorieDao.getInstance(context).getAllEntriesAsList();
    }
}
