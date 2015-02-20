package com.kuehlschrankapp.db.config;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.kuehlschrankapp.db.dto.impl.Artikel;
import com.kuehlschrankapp.db.dto.impl.Einheit;
import com.kuehlschrankapp.db.dto.impl.Einkaufsliste;
import com.kuehlschrankapp.db.dto.impl.Kategorie;
import com.kuehlschrankapp.db.dto.impl.Rezept;
import com.kuehlschrankapp.db.dto.impl.Rezept_hat_Artikel;
import com.kuehlschrankapp.db.dto.impl.Vorhandene_Lebensmittel;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by laj on 16.02.2015.
 * Schreibt ormlite_config.txt in den raw Ordner
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[]{Artikel.class, Einheit.class, Einkaufsliste.class, Kategorie.class, Rezept_hat_Artikel.class, Rezept.class, Vorhandene_Lebensmittel.class};

    public static void main(String[] args) throws SQLException, IOException {
        writeConfigFile("ormlite_config.txt", classes);
    }
}
