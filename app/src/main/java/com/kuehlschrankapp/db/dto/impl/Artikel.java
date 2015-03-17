package com.kuehlschrankapp.db.dto.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by laj on 16.02.2015.
 * Tabelle Artikel
 */

@DatabaseTable
public class Artikel {
    public final static String ID_FIELD_NAME = "id";
    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField(foreign = true, columnName = "einheit_einkauf_id", foreignColumnName = Einheit.ID_FIELD_NAME)
    private Einheit einheitEinkauf;

    @DatabaseField(foreign = true, columnName = "einheit_kochen_id", foreignColumnName = Einheit.ID_FIELD_NAME)
    private Einheit einheitKochen;

    @DatabaseField(foreign = true, columnName = "kategorie_id", foreignColumnName = Kategorie.ID_FIELD_NAME)
    private Kategorie kategorie;

    @DatabaseField
    private boolean istLebensmittel;

    @DatabaseField
    private int standardmenge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Einheit getEinheitEinkauf() {
        return einheitEinkauf;
    }

    public void setEinheitEinkauf(Einheit einheitEinkauf) {
        this.einheitEinkauf = einheitEinkauf;
    }

    public Einheit getEinheitKochen() {
        return einheitKochen;
    }

    public void setEinheitKochen(Einheit einheitKochen) {
        this.einheitKochen = einheitKochen;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public boolean isIstLebensmittel() {
        return istLebensmittel;
    }

    public void setIstLebensmittel(boolean istLebensmittel) {
        this.istLebensmittel = istLebensmittel;
    }

    public int getStandardmenge() {
        return standardmenge;
    }

    public void setStandardmenge(int standardmenge) {
        this.standardmenge = standardmenge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artikel() {
    }

    public Artikel(String name, Einheit einheitEinkauf, Einheit einheitKochen, Kategorie kategorie, boolean istLebensmittel, int standardmenge) {
        this.name = name;
        this.einheitEinkauf = einheitEinkauf;
        this.einheitKochen = einheitKochen;
        this.kategorie = kategorie;
        this.istLebensmittel = istLebensmittel;
        this.standardmenge = standardmenge;
    }

    @Override
    public String toString() {
        return name;
    }

}
