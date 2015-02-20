package com.kuehlschrankapp.db.dto.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by laj on 16.02.2015.
 * Tabelle Rezept_hat_Artikel
 */
@DatabaseTable
public class Rezept_hat_Artikel {

    @DatabaseField (foreign = true, columnName = "rezept_id", foreignColumnName = Rezept.ID_FIELD_NAME)
    private Rezept rezept;

    @DatabaseField(foreign = true, columnName = "artikel_id", foreignColumnName =  Artikel.ID_FIELD_NAME)
    private Artikel artikel;

    @DatabaseField
    private double menge;

    public Rezept getRezept() {
        return rezept;
    }

    public void setRezept(Rezept rezept) {
        this.rezept = rezept;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }

    public Rezept_hat_Artikel() {
    }

    public Rezept_hat_Artikel(Artikel artikel, Rezept rezept, double menge) {
        this.artikel = artikel;
        this.rezept = rezept;
        this.menge = menge;
    }
}
