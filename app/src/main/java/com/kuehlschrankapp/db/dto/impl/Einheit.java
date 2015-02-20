package com.kuehlschrankapp.db.dto.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by laj on 16.02.2015.
 * Tabelle Einheit
 */

@DatabaseTable
public class Einheit {
    public final static String ID_FIELD_NAME = "id";
    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField
    private String einheit;

    @DatabaseField
    private String kuerzel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public Einheit() {

    }

    public Einheit(String einheit, String kuerzel) {
        this.einheit = einheit;
        this.kuerzel = kuerzel;
    }
    @Override
    public String toString() {
        return  einheit + " " + kuerzel;
    }
}
