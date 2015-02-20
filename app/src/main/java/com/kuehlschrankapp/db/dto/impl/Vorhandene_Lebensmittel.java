package com.kuehlschrankapp.db.dto.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by laj on 16.02.2015.
 * Tabelle Vorhandene_Lebensmittel
 */
@DatabaseTable
public class Vorhandene_Lebensmittel {

    @DatabaseField(foreign = true, columnName = "artikel_id", foreignColumnName = Artikel.ID_FIELD_NAME)
    private Artikel artikel;

    @DatabaseField
    private int menge;

    @DatabaseField
    private boolean favorit;

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

    public boolean isFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }

    public Vorhandene_Lebensmittel() {
    }

    public Vorhandene_Lebensmittel(Artikel artikel, int menge, boolean favorit) {
        this.artikel = artikel;
        this.menge = menge;
        this.favorit = favorit;
    }
}
