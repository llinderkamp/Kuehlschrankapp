package com.kuehlschrankapp.db.dto.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by laj on 16.02.2015.
 * Tabelle Kategorie
 */
@DatabaseTable
public class Kategorie {
    public final static String ID_FIELD_NAME = "id";
    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private  String iconName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Kategorie() {
    }

    public Kategorie(String name, String iconName) {
        this.name = name;
        this.iconName = iconName;
    }

    @Override
    public String toString() {
        return name;
    }
}
