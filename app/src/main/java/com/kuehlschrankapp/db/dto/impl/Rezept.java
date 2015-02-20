package com.kuehlschrankapp.db.dto.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by laj on 16.02.2015.
 * Tabelle Rezept
 */
@DatabaseTable
public class Rezept {
    public final static String ID_FIELD_NAME = "id";
    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String zubereitung;

    @DatabaseField
    private int portionen;

    @DatabaseField
    private int zubereitungszeit;

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

    public String getZubereitung() {
        return zubereitung;
    }

    public void setZubereitung(String zubereitung) {
        this.zubereitung = zubereitung;
    }

    public int getPortionen() {
        return portionen;
    }

    public void setPortionen(int portionen) {
        this.portionen = portionen;
    }

    public int getZubereitungszeit() {
        return zubereitungszeit;
    }

    public void setZubereitungszeit(int zubereitungszeit) {
        this.zubereitungszeit = zubereitungszeit;
    }

    public Rezept() {
    }

    public Rezept(String name, String zubereitung, int portionen, int zubereitungszeit) {
        this.name = name;
        this.zubereitung = zubereitung;
        this.portionen = portionen;
        this.zubereitungszeit = zubereitungszeit;
    }
}
