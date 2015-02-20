package com.kuehlschrankapp.db.dto.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by laj on 16.02.2015.
 * Tabelle Einkaufsliste
 */
@DatabaseTable
public class Einkaufsliste {

    @DatabaseField (foreign = true, columnName = "artikel_id", foreignColumnName = Artikel.ID_FIELD_NAME)
    private Artikel artikel;

    @DatabaseField
    private int menge;

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Einkaufsliste() {
    }

    public Einkaufsliste(Artikel artikel, int menge) {
        this.artikel = artikel;
        this.menge = menge;
    }
}
