package com.kuehlschrankapp.db.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.kuehlschrankapp.R;
import com.kuehlschrankapp.db.dto.impl.Artikel;
import com.kuehlschrankapp.db.dto.impl.Einheit;
import com.kuehlschrankapp.db.dto.impl.Einkaufsliste;
import com.kuehlschrankapp.db.dto.impl.Kategorie;
import com.kuehlschrankapp.db.dto.impl.Rezept;
import com.kuehlschrankapp.db.dto.impl.Rezept_hat_Artikel;
import com.kuehlschrankapp.db.dto.impl.Vorhandene_Lebensmittel;

import java.sql.SQLException;

/**
 * Created by laj on 16.02.2015.
 * Installiert und Upgraded die Datebank wenn die App installiert wird
 * Initilasiert die statischen Daten der Datenbank
 */
public class AbstractDatabaseOpenHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABSE_NAME = "database.db";
    private static final int DATABSE_VERSION = 1;

    public AbstractDatabaseOpenHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABSE_VERSION, R.raw.ormlite_config);
    }

    /**
     * Erstellt die Datenbank bei erstmaliger Installation der App
     * @param sqLiteDatabase Datenbank
     * @param connectionSource Verbindung
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Artikel.class);
            TableUtils.createTable(connectionSource, Einheit.class);
            TableUtils.createTable(connectionSource, Einkaufsliste.class);
            TableUtils.createTable(connectionSource, Kategorie.class);
            TableUtils.createTable(connectionSource, Rezept_hat_Artikel.class);
            TableUtils.createTable(connectionSource, Rezept.class);
            TableUtils.createTable(connectionSource, Vorhandene_Lebensmittel.class);
            initStaticDatabaseValues();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Übernimmt das Upgrade der Datenbanktabellen, wenn eine neuere Version der App installiert wird
     * @param sqLiteDatabase Datenbank
     * @param connectionSource Verbindung
     * @param i alte Version der DB
     * @param i2 neue Version der DB
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            TableUtils.dropTable(connectionSource, Artikel.class, true);
            TableUtils.dropTable(connectionSource, Einheit.class, true);
            TableUtils.dropTable(connectionSource, Einkaufsliste.class, true);
            TableUtils.dropTable(connectionSource, Kategorie.class, true);
            TableUtils.dropTable(connectionSource, Rezept_hat_Artikel.class, true);
            TableUtils.dropTable(connectionSource, Rezept.class, true);
            TableUtils.dropTable(connectionSource, Vorhandene_Lebensmittel.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode um die statischen Daten in der Datenbank zu initialisieren
     */
    private void initStaticDatabaseValues() {
        // Einheiten
        final RuntimeExceptionDao<Einheit, ?> runtimeExceptionDaoEinheit = getRuntimeExceptionDao(Einheit.class);
        Einheit becher = new Einheit("Becher", "Bch.");
        runtimeExceptionDaoEinheit.create(becher);
        Einheit blatt = new Einheit("Blatt", "Bl.");
        runtimeExceptionDaoEinheit.create(blatt);
        Einheit bund = new Einheit("Bund", "Bd.");
        runtimeExceptionDaoEinheit.create(bund);
        Einheit dosen = new Einheit("Dose(n)", "Dose(n)");
        runtimeExceptionDaoEinheit.create(dosen);
        Einheit el = new Einheit("Esslöffel", "EL");
        runtimeExceptionDaoEinheit.create(el);
        Einheit flaschen = new Einheit("Flasche(n)", "Fl.");
        runtimeExceptionDaoEinheit.create(flaschen);
        Einheit glas = new Einheit("Glas", "Gl.");
        runtimeExceptionDaoEinheit.create(glas);
        Einheit g =  new Einheit("Gramm", "g");
        runtimeExceptionDaoEinheit.create(g);
        Einheit große = new Einheit("große", "gr.");
        runtimeExceptionDaoEinheit.create(große);
        Einheit karton = new Einheit("Karton", "Kart.");
        runtimeExceptionDaoEinheit.create(karton);
        Einheit kg = new Einheit("Kilogramm", "kg");
        runtimeExceptionDaoEinheit.create(kg);
        Einheit kleine = new Einheit("kleine", "kl.");
        runtimeExceptionDaoEinheit.create(kleine);
        Einheit knolle = new Einheit("Knolle(n)", "Kn.");
        runtimeExceptionDaoEinheit.create(knolle);
        Einheit kopf = new Einheit("Kopf", "Kopf");
        runtimeExceptionDaoEinheit.create(kopf);
        Einheit kugeln = new Einheit("Kugel(n)", "Kugel(n)");
        runtimeExceptionDaoEinheit.create(kugeln);
        Einheit liter = new Einheit("Liter", "l");
        runtimeExceptionDaoEinheit.create(liter);
        Einheit msp = new Einheit("Messerspitze", "Msp.");
        runtimeExceptionDaoEinheit.create(msp);
        Einheit ml = new Einheit("Milliliter", "ml");
        runtimeExceptionDaoEinheit.create(ml);
        Einheit nb = new Einheit("nach Belieben", "n.B.");
        runtimeExceptionDaoEinheit.create(nb);
        Einheit paar = new Einheit("Paar", "Paar");
        runtimeExceptionDaoEinheit.create(paar);
        Einheit pck = new Einheit("Päckchen", "Pck.");
        runtimeExceptionDaoEinheit.create(pck);
        Einheit pf = new Einheit("Pfund", "Pf");
        runtimeExceptionDaoEinheit.create(pf);
        Einheit portionen = new Einheit("Portionen", "Portionen");
        runtimeExceptionDaoEinheit.create(portionen);
        Einheit prisen = new Einheit("Prise(n)", "Prise(n)");
        runtimeExceptionDaoEinheit.create(prisen);
        Einheit ring = new Einheit("Ring", "Ring");
        runtimeExceptionDaoEinheit.create(ring);
        Einheit spr = new Einheit("Spritzer", "Spr.");
        runtimeExceptionDaoEinheit.create(spr);
        Einheit stg = new Einheit("Stängel", "Stg.");
        runtimeExceptionDaoEinheit.create(stg);
        Einheit stk = new Einheit("Stück", "Stk.");
        runtimeExceptionDaoEinheit.create(stk);
        Einheit tafeln = new Einheit("Tafel(n)", "Tafel(n)");
        runtimeExceptionDaoEinheit.create(tafeln);
        Einheit tassen = new Einheit("Tasse(n)", "Tasse(n)");
        runtimeExceptionDaoEinheit.create(tassen);
        Einheit tl = new Einheit("Teelöffel", "tl");
        runtimeExceptionDaoEinheit.create(tl);
        Einheit tr = (new Einheit("Tropfen", "Tr."));
        runtimeExceptionDaoEinheit.create(tr);
        Einheit tuben = new Einheit("Tube(n)", "Tube(n)");
        runtimeExceptionDaoEinheit.create(tuben);
        Einheit tueten = new Einheit("Tüte(n)", "Tüte(n)");
        runtimeExceptionDaoEinheit.create(tueten);
        Einheit wf = new Einheit("Würfel", "Wf");
        runtimeExceptionDaoEinheit.create(wf);
        Einheit zehen = new Einheit("Zehen", "Z");
        runtimeExceptionDaoEinheit.create(zehen);

        // Kategorien
        final RuntimeExceptionDao<Kategorie, ?> runtimeExceptionDaoKategorie = getRuntimeExceptionDao(Kategorie.class);
        Kategorie obst = new Kategorie("Obst und Gemüse", "ic_obst");
        runtimeExceptionDaoKategorie.create(obst);
        Kategorie brot = (new Kategorie("Brot und Gebäck", "ic_brot"));
        runtimeExceptionDaoKategorie.create(brot);
        Kategorie milchKaese = new Kategorie("Milch und Käse", "ic_milch");
        runtimeExceptionDaoKategorie.create(milchKaese);
        Kategorie fleisch = new Kategorie("Fleisch und Fisch", "ic_fleisch");
        runtimeExceptionDaoKategorie.create(fleisch);
        Kategorie gewuerze = new Kategorie("Gewürze und Kräuter", "ic_gewuerze");
        runtimeExceptionDaoKategorie.create(gewuerze);
        Kategorie tiefkuehl = new Kategorie("Tiefkühl- und Fertigprodukte", "ic_tiefkuehl");
        runtimeExceptionDaoKategorie.create(tiefkuehl);
        Kategorie getreide = new Kategorie("Getreideprodukte", "ic_getreide");
        runtimeExceptionDaoKategorie.create(getreide);
        Kategorie snacks = new Kategorie("Snacks und Süßwaren", "ic_snacks");
        runtimeExceptionDaoKategorie.create(snacks);
        Kategorie haushalt = (new Kategorie("Haushalt", "ic_haushalt"));
        runtimeExceptionDaoKategorie.create(haushalt);
        Kategorie backzutaten = new Kategorie("Backzutaten", "ic_backzutaten");
        runtimeExceptionDaoKategorie.create(backzutaten);
        Kategorie aufstriche = new Kategorie("Aufstriche", "ic_aufstrich");
        runtimeExceptionDaoKategorie.create(aufstriche);
        Kategorie getraenke = new Kategorie("Getränke", "ic_getraenke");
        runtimeExceptionDaoKategorie.create(getraenke);
        Kategorie konserven = new Kategorie("Konserven", "ic_konserven");
        runtimeExceptionDaoKategorie.create(konserven);
        Kategorie oelFett = new Kategorie("Öl und Fett", "ic_oel");
        runtimeExceptionDaoKategorie.create(oelFett);

        // Artikel
        final RuntimeExceptionDao<Artikel, ?> runtimeExceptionDaoArtikel = getRuntimeExceptionDao(Artikel.class);
        Artikel apfel = new Artikel("Apfel", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(apfel);
        Artikel milch = new Artikel("Milch", liter, ml, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(milch);
        Artikel banane = new Artikel("Banane", stk,stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(banane);
        Artikel hackfleisch = new Artikel("Hackfleisch", g,g,  fleisch, true, 500);
        runtimeExceptionDaoArtikel.create(hackfleisch);
        Artikel haenchenbrustfilet = new Artikel("Hänchenbrustfilet", g, g, fleisch, true, 500);
        runtimeExceptionDaoArtikel.create(haenchenbrustfilet);
        Artikel salz = new Artikel("Salz", pck, prisen, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(salz);
        Artikel pfeffer = new Artikel("Pfeffer", pck, nb, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(pfeffer);
        Artikel lappen = new Artikel("Lappen", stk, stk, haushalt, false, 1);
        runtimeExceptionDaoArtikel.create(lappen);
        Artikel schwamm = new Artikel("Schwamm", stk, stk, haushalt, false, 1);
        runtimeExceptionDaoArtikel.create(schwamm);
        Artikel spuelmittel = new Artikel("Spülmittel", stk, stk, haushalt, false, 1);
        runtimeExceptionDaoArtikel.create(spuelmittel);
        Artikel schinkenwürfel = new Artikel("Schinkenwürfel", pck, g, fleisch, true, 1);
        runtimeExceptionDaoArtikel.create(schinkenwürfel);
        Artikel oelSonnenblume = new Artikel("Sonnenblumenöl", flaschen, el, oelFett, true, 1);
        runtimeExceptionDaoArtikel.create(oelSonnenblume);
        Artikel oelOlive = new Artikel("Olivenöl",flaschen, el, oelFett, true, 1);
        runtimeExceptionDaoArtikel.create(oelOlive);
        Artikel eier = new Artikel("Eier", stk, stk, backzutaten, true, 10);
        runtimeExceptionDaoArtikel.create(eier);
        Artikel sahne = new Artikel("Sahne", becher, ml, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(sahne);
        Artikel parmesan = new Artikel("Parmesan", pck, g, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(parmesan);
        Artikel spaghetti = new Artikel("Spaghetti", pck, g, getreide, true, 1);
        runtimeExceptionDaoArtikel.create(spaghetti);
        Artikel salat = new Artikel("Gemischter Salat", pck, pck, obst, true, 1);
        runtimeExceptionDaoArtikel.create(salat);
        Artikel krebse = new Artikel("Flusskrebsschwänze", pck, g, fleisch, true, 1);
        runtimeExceptionDaoArtikel.create(krebse);
        Artikel paprika = new Artikel("Paprika", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(paprika);
        Artikel kresse = new Artikel("Kresse", pck, pck, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(kresse);
        Artikel honig = new Artikel("Honig", glas, g, aufstriche, true, 1);
        runtimeExceptionDaoArtikel.create(honig);
        Artikel balsamico = new Artikel("Balsamico", flaschen, el, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(balsamico);
        Artikel walnuesse = new Artikel("Walnüsse", tueten, g, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(walnuesse);
        Artikel cornedBeef = new Artikel("Corned Beef", pck, pck, fleisch, true, 1);
        runtimeExceptionDaoArtikel.create(cornedBeef);
        Artikel kartoffeln = new Artikel("Kartoffeln", kg, kg, obst, true, 2);
        runtimeExceptionDaoArtikel.create(kartoffeln);
        Artikel gewuergurken = new Artikel("Gewürgurken", glas, stk, konserven, true, 1);
        runtimeExceptionDaoArtikel.create(gewuergurken);
        Artikel zwiebeln = new Artikel("Zwiebeln", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(zwiebeln);
        Artikel roteBeete = new Artikel("Rote Beete", glas, stk, konserven, true, 1);
        runtimeExceptionDaoArtikel.create(roteBeete);
        Artikel piment = new Artikel("Piment", pck, nb, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(piment);
        Artikel margarine = new Artikel("Margarine", pck, g, oelFett, true, 1);
        runtimeExceptionDaoArtikel.create(margarine);
        Artikel butter = new Artikel("Butter", pck, g, oelFett, true, 1);
        runtimeExceptionDaoArtikel.create(butter);
        Artikel zucker = new Artikel("Zucker", pck, g, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(zucker);
        Artikel vanillezucker = new Artikel("Vanillezucker", pck, pck, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(vanillezucker);
        Artikel orangenlimonade = new Artikel("Orangenlimonade", flaschen, ml, getraenke, true, 1);
        runtimeExceptionDaoArtikel.create(orangenlimonade);
        Artikel mehl = new Artikel("Mehl", pck, g, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(mehl);
        Artikel backpulver = new Artikel("Backpulver", pck, pck, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(backpulver);
        Artikel natron = new Artikel("Natron", pck, tl, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(natron);
        Artikel braunerZucker = new Artikel("Brauner Zucker", pck, g, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(braunerZucker);
        Artikel schokolade = new Artikel("Schokolade", pck, g, snacks, true, 1);
        runtimeExceptionDaoArtikel.create(schokolade);
        Artikel schokoladeZartbitter = new Artikel("Schokolade Zartbitter", pck, g, snacks, true, 1);
        runtimeExceptionDaoArtikel.create(schokoladeZartbitter);
        Artikel knoblauch = new Artikel("Knoblauch", knolle, zehen, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(knoblauch);
        Artikel moehren = new Artikel("Möhren", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(moehren);
        Artikel staudensellerie = new Artikel("Staudensellerie", stg, stg, obst, true, 1);
        runtimeExceptionDaoArtikel.create(staudensellerie);
        Artikel dosenTomaten = new Artikel("Dosen Tomaten", dosen, dosen, konserven, true, 1);
        runtimeExceptionDaoArtikel.create(dosenTomaten);
        Artikel peperoncini = new Artikel("Peperoncini", stk, stk, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(peperoncini);
        Artikel huenerbruehe = new Artikel("Hühnerbrühe", glas, tl, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(huenerbruehe);
        Artikel gemuesebruehe = new Artikel("Gemüsebrühe", wf, wf, gewuerze, true, 8);
        runtimeExceptionDaoArtikel.create(gemuesebruehe);
        Artikel weißwein = new Artikel("Weißwein", flaschen, ml, getraenke, true, 1);
        runtimeExceptionDaoArtikel.create(weißwein);
        Artikel rotwein = new Artikel("Rotwein", flaschen, ml, getraenke, true, 1);
        runtimeExceptionDaoArtikel.create(rotwein);
        Artikel cremeFraiche = new Artikel("Creme Fraiche", becher, becher, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(cremeFraiche);
        Artikel schmand = new Artikel("Schmand", becher, becher, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(schmand);
        Artikel schnittlauch = new Artikel("Schnittlauch", bund, bund,gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(schnittlauch);
        Artikel lauch = new Artikel("Lauch", stg, stg, obst, true, 1);
        runtimeExceptionDaoArtikel.create(lauch);
        Artikel schmelzkaese = new Artikel("Schmelzkäse", becher, g, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(schmelzkaese);
        Artikel getrockeneTomaten = new Artikel("Getrocknete Tomaten", glas, g, konserven, true, 1);
        runtimeExceptionDaoArtikel.create(getrockeneTomaten);
        Artikel basilikum = new Artikel("Basilikum", bund, blatt, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(basilikum);
        Artikel pinienkerne = new Artikel("Pinienkerne", tueten, g, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(pinienkerne);
        Artikel chilliSchoten = new Artikel("Chillischoten", stk, stk, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(chilliSchoten);
        Artikel joghurt = new Artikel("Joghurt", becher, g, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(joghurt);
        Artikel quark = new Artikel("Quark", becher, g, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(quark);
        Artikel rosinen = new Artikel("Rosinen", tueten, g,obst, true, 1);
        runtimeExceptionDaoArtikel.create(rosinen);
        Artikel haferflocken = new Artikel("Haferflocken", pck, g, getreide, true, 1);
        runtimeExceptionDaoArtikel.create(haferflocken);
        Artikel sahnesteif = new Artikel("Sahnesteif", pck, pck, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(sahnesteif);
        Artikel orange = new Artikel("Orange", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(orange);
        Artikel zitrone = new Artikel("Zitrone", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(zitrone);
        Artikel mango = new Artikel("Mango", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(mango);
        Artikel orangensaft = new Artikel("Orangensaft", flaschen, el, getraenke, true, 1);
        runtimeExceptionDaoArtikel.create(orangensaft);
        Artikel zitronensaft = new Artikel("Zitronensaft", flaschen, el, getraenke, true, 1);
        runtimeExceptionDaoArtikel.create(zitronensaft);
        Artikel endiviensalat = new Artikel("Endiviensalat", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(endiviensalat);
        Artikel essig = new Artikel("Essig", flaschen, el, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(essig);
        Artikel erdbeeren = new Artikel("Erdbeeren", pck, g, obst, true, 1);
        runtimeExceptionDaoArtikel.create(erdbeeren);
        Artikel mais = new Artikel("Mais", dosen, dosen, konserven, true, 1);
        runtimeExceptionDaoArtikel.create(mais);
        Artikel kidneybohnen = new Artikel("Kidneybohnen", dosen, dosen, konserven, true, 1);
        runtimeExceptionDaoArtikel.create(kidneybohnen);
        Artikel tomatenmark = new Artikel("Tomatenmark", tuben, el, konserven, true, 1);
        runtimeExceptionDaoArtikel.create(tomatenmark);
        Artikel tomate = new Artikel("Tomate", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(tomate);
        Artikel gurke = new Artikel("Gurke", stk, stk, obst, true, 1);
        runtimeExceptionDaoArtikel.create(gurke);
        Artikel paprikapulver = new Artikel("paprikapulver", pck, nb, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(paprikapulver);
        Artikel oregano = new Artikel("Oregano", pck, nb, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(oregano);
        Artikel petersilie = new Artikel("Petersilie", bund, blatt, gewuerze, true, 1);
        runtimeExceptionDaoArtikel.create(petersilie);
        Artikel kaese = new Artikel("Käse", stk, g, milchKaese, true, 1);
        runtimeExceptionDaoArtikel.create(kaese);
        Artikel tortilla = new Artikel("Tortilla", pck, stk, getreide, true, 1);
        runtimeExceptionDaoArtikel.create(tortilla);
        Artikel hefe = new Artikel("Hefe", pck, g, backzutaten, true, 1);
        runtimeExceptionDaoArtikel.create(hefe);
        Artikel kalbsschnitzel = new Artikel("Kalbsschnitzeln", stk, stk, fleisch, true, 1);
        runtimeExceptionDaoArtikel.create(kalbsschnitzel);
        Artikel kochschinken = new Artikel("Kochschinken", pck, stk, fleisch, true, 1);
        runtimeExceptionDaoArtikel.create(kochschinken);
        Artikel paniermehl = new Artikel("Paniermehl", pck, g, brot, true, 1);
        runtimeExceptionDaoArtikel.create(paniermehl);
        Artikel champignons = new Artikel("Champignons", pck, g, obst, true, 1);
        runtimeExceptionDaoArtikel.create(champignons);
        Artikel reis = new Artikel("Reis", pck, g, getreide, true, 1);
        runtimeExceptionDaoArtikel.create(reis);
        Artikel toastbrot = new Artikel("Toastbrot", pck, stk, brot, true, 1);
        runtimeExceptionDaoArtikel.create(toastbrot);
        Artikel nutella = new Artikel("Nutella", glas, el, aufstriche, true, 1);
        runtimeExceptionDaoArtikel.create(nutella);
        Artikel lachs = new Artikel("Lachs", pck, g, fleisch, true, 1);
        runtimeExceptionDaoArtikel.create(lachs);
        Artikel wasser = new Artikel("Wasser", ml, ml, getraenke, false, 1);
        runtimeExceptionDaoArtikel.create(wasser);
        Artikel butterschmalz = new Artikel("Butterschmalz", g, g, oelFett, true, 1);
        runtimeExceptionDaoArtikel.create(butterschmalz);

        // Rezepte
        final RuntimeExceptionDao<Rezept, ?> runtimeExceptionDaoRezept = getRuntimeExceptionDao(Rezept.class);
        Rezept carbonara = new Rezept("Spaghetti Carbonara", "Schinkenwürfel im Öl anbraten. \n" +
                "Währenddessen Spaghetti kochen und Eigelb mit Sahne und Parmesan verquirlen, salzen und gut pfeffern.\n" +
                "Eimasse schnell mit den gekochten, abgetropften Spaghetti und den krossen Schinken- oder Speckwürfeln mischen. \n" +
                "Ich fülle dazu die abgetropften Spaghetti (die ruhig noch ein bisschen feucht sein können) wieder in den heißen Topf " +
                "und stelle ihn wieder auf die ausgeschaltete Kochstelle. Dort wird alles nur so lange vermischt, bis das Eigelb bindet. Nicht zu " +
                "lange rühren, sonst erhält man ein Rührei. Noch einmal gut mit Salz und Pfeffer abschmecken.", 2, 20);
        runtimeExceptionDaoRezept.create(carbonara);

        Rezept salatGemischt = new Rezept("Gemischter Salat mit einem Honig - Walnussdressing", "Für das Honig-Walnussdressing 1-2 EL Honig mit 1 EL Wasser in einem Topf erwärmen (der Honig sollte dann flüssig sein), etwas abkühlen lassen und dann das Olivenöl mit einem Schneebesen einrühren. Nun den Balsamico-Essig dazu geben (im typischen Verhältnis 4 Teile Öl und 1 Teil Essig). Das Ganze mit Pfeffer und Salz abschmecken. Dann die Walnüsse dazugeben.\n" +
                "\n" +
                "Danach den Salat waschen und trocken schleudern. Die Paprika in feine Streifen schneiden und waschen.\n" +
                "\n" +
                "Die Flusskrebsschwänze in kaltem Wasser kurz auftauen, evt. säubern und mit einem Küchentuch trocken tupfen. In einer heißen Pfanne mit etwas Olivenöl kurz anbraten. Danach evt. etwas grünes Pesto mit in die Pfanne geben und die Schwänze noch einmal durchschwenken.\n" +
                "\n" +
                "Den Salat mit dem Dressing schön vermengen und in der Mitte eines Tellers ein Bouquet anrichten. Die gebratenen Flusskrebsschwänze drum herum verteilen und Paprikastreifen und ein kleines" +
                " Kressesträußchen auf den Salat legen.", 4, 20);
        runtimeExceptionDaoRezept.create(salatGemischt);

        Rezept labskaus = new Rezept("Labskaus", "Die Kartoffeln als Salzkartoffeln kochen. In der Zwischenzeit die klein gewürfelten Zwiebeln in etwas Fett andünsten, " +
                "bis sie blond sind. Das kleingeschnittene Corned Beef zufügen und mit Deckel etwa 3 Minuten schmoren lassen. Dann die gewürfelten Gewürzgurken mit etwas vom " +
                "Sud zufügen. Mit Salz, Pfeffer und Piment herzhaft abschmecken. Wenn gewünscht, eventuell noch etwas gewürfelte Rote Beete zugeben. Alles etwa 10 Minuten leicht " +
                "durchkochen lassen. Die fertig gegarten Kartoffeln etwas stampfen (Nicht so fein wie für Püree!). Das geschmorte Corned Beef Mix unterrühren. Wenn es zu fest ist noch " +
                "etwas Gurkenwasser unterrühren.", 4, 60);
        runtimeExceptionDaoRezept.create(labskaus);

        Rezept fantakuchen = new Rezept("Fantakuchen", "Eier, Zucker, Vanillinzucker schaumig schlagen, Öl und Limonade unterziehen. " +
                "Mehl und Backpulver unterrühren. Auf einem Blech verteilen und bei 180°C ca. 25 Minuten goldbraun backen.", 1, 45);
        runtimeExceptionDaoRezept.create(fantakuchen);

        Rezept chocolateChipCookies = new Rezept("Chocolate Chip Cookies", "Den Ofen auf 190 Grad vorheizen\n" +
                "Mehl, Natron und Salz in einer kleinen Schüssel mischen und beiseite stellen.\n" +
                "Butter, Zucker, braunen Zucker und Vanille in einer großen Schüssel cremig schlagen. Eier einzeln zugeben und jedes Mal gut unterrühren.\n" +
                "Die Mehlmischung portionsweise untermengen, dann Schokostückchen zufügen.\n" +
                "Jeweils 1 gehäuften Esslöffel Teig auf ein nicht eingefettetes Backblech setzen. 9-11 Minuten backen, bis die Cookies goldbraun sind. " +
                "Weitere 2 Minuten auf dem Blech liegen lassen (noch weich), dann auf einem Kuchengitter auskühlen lassen.\n" +
                "\n" +
                "Cookies sind noch weich wenn sie aus dem Backofen kommen, sie werden fester beim Abkühlen.", 1, 45);
        runtimeExceptionDaoRezept.create(chocolateChipCookies);

        Rezept tiramisu = new Rezept("Tiramisu", "Eigelb, Puderzucker, Mascarpone und Amaretto cremig rühren. Das Eiweiß steif schlagen und vorsichtig unterheben. " +
                "Die Löffelbiskuits mit dem Espresso/starken Kaffee tränken oder nach Geschmack auch nur einpinseln. 4 Lagen Schichten, begonnen mit Biskuits, Mascarponecreme, " +
                "Biskuits und wieder Mascarponecreme. Mit Kakao dick bestäuben und kühl stellen.", 4, 60);
        runtimeExceptionDaoRezept.create(tiramisu);

        Rezept bolognese = new Rezept("Spaghetti Bolognese", "Das wichtigste an einer Bolognese ist das sog. „Soffritto“:\n" +
                "Dazu einen ordentlichen Klotz Butter (ca. 125 g) und ein wenig Olivenöl (damit die Butter nicht verbrennt) in eine Pfanne geben. Zwiebeln, Möhren und Staudensellerie putzen bzw. schälen, ganz fein hacken und auf möglichst niedriger Flamme langsam (mind. 30 Minuten) darin garen, bis das Gemüse schön glasig und weich geworden ist. \n" +
                "Wichtig ist, dass das Gemüse nicht brät, sondern wirklich nur gart - also nicht zu heiß werden lassen!\n" +
                "\n" +
                "Derweil das Rinderhackfleisch so lange in einer weiteren Pfanne scharf anbraten, bis es anfängt zu karamellisieren. Anschließend mit einem Schuss Weißwein ablöschen, so dass sich alles Angebackene vom Boden lösen lässt. Wichtig: Jetzt je nach Saucenmenge ca.1/4 bis 1/2 Liter Milch hinzugeben, die sich um das Hackfleisch legt und diesem einen ganz milden Geschmack verleiht.\n" +
                "\n" +
                "Sobald das Fleisch mit Weißwein und Milch aufkocht, die Dosentomaten hinzugeben (die erforderlichen frischen Tomaten sind bei uns leider nicht erhältlich). Am besten geeignet sind hierfür die „San Marzano“ Eiertomaten aus der Gegend von Neapel. Diese haben einen ganz eigenen süßlichen Geschmack, der der Sauce „Bolognese“ und auch einer ordentlichen Sauce „Napoli“ sehr zuträglich ist. Günstig und trotzdem sehr schmackhaft sind die Dosentomaten von „Vitale“.\n" +
                "\n" +
                "Sobald dies alles wieder aufgekocht ist, den „Soffritto“ hinzugeben. Der in Scheiben geschnittene Knoblauch und die zerstampften Peperoncini können jetzt auch mit hinein. Das Ganze kann dann gar nicht lange genug köcheln. Ideal wären dabei ca. 5 Stunden. Dann abkühlen lassen und dann noch einmal 1 Stunde langsam aufwärmen (muss aber nicht, schmeckt auch so). Mindestens 2 Stunden sollte es aber köcheln.\n" +
                "Tipp: Man kann auch noch ein wenig frisch gehackte Möhre und Staudensellerie nachschieben, um ein wenig mehr Biss an das Gemüse zu kriegen. Mit Meersalz, frisch gemahlenem schwarzen Pfeffer und der Hühnerbrühe abschmecken.\n" +
                "\n" +
                "In der Zwischenzeit die Nudeln nach Packungsanweisung bissfest kochen, anschließend abgießen.\n" +
                "\n" +
                "Die Spaghetti auf Tellern anrichten und die Bolognese darüber verteilen. Heiß servieren.", 6, 300);
        runtimeExceptionDaoRezept.create(bolognese);

        Rezept flammkuchen = new Rezept("Flammkuchen", "Backofen auf 250° vorheizen.\n" +
                "Knetteig bereiten, ganz dünn ausrollen. \n" +
                "Schmand und Crème double mischen, würzen und auf dem Teig verstreichen. \n" +
                "Zwiebeln mit ganz wenig Wasser 1 Minute bei 600 Watt in der Mikrowelle dünsten. Mit dem Speck auf dem Belag verteilen.\n" +
                "20 Minuten backen (untere Einschubleiste). Mit Schnittlauchröllchen bestreut servieren.", 2, 30);
        runtimeExceptionDaoRezept.create(flammkuchen);

        Rezept kaeseSuppe = new Rezept("Käse - Lauch - Suppe mit Hackfleisch", "Öl in einen großen Topf geben. Das Hackfleisch darin von allen Seiten gut anbraten und mit Salz und Pfeffer würzen." +
                " Den Lauch in kleine Ringe schneiden und zum Hackfleisch geben. Ca. 5 Minuten mit anbraten. Das Wasser zugießen, Brühwürfel hineingeben und alles ca. 10 Minuten auf kleiner Flamme " +
                "köcheln lassen. Den Schmelzkäse einrühren und schmelzen lassen. Creme fraiche einrühren und noch einmal kurz aufkochen lassen. Die Suppe mit Salz und Pfeffer kräftig abschmecken. ", 4, 40);
        runtimeExceptionDaoRezept.create(kaeseSuppe);

        Rezept pestoRosso = new Rezept("Pesto Rosso", "Knoblauch schälen und grob hacken, Basilikum waschen, trocknen und grob zerkleinern, Chili von Strunk befreien, entkernen und grob zerkleinern, getrocknete Tomaten grob zerkleinern, Käse ebenfalls grob zerkleinern. \n" +
                "Alle Zutaten in einen Mixbecher geben, mit Öl auffüllen und kräftig mit dem Mixstab durchmixen. Mit Salz und Pfeffer abschmecken. \n" +
                "Am besten gleich frisch auf Crostini oder mit Nudeln servieren. Auch sehr lecker als Dip zu frischem Weißbrot oder zum Fondue.", 4, 10);
        runtimeExceptionDaoRezept.create(pestoRosso);

        Rezept joghurtSahneMuesli = new Rezept("Joghurt - Sahne - Müsli", "Alle Milchprodukte und den Zucker - außer Vanillinzucker sowie 100 g Sahne - in eine große Schüssel geben und verrühren. " +
                "Die Haferflocken und Rosinen sowie die gehackten Walnüsse hinzugeben und unterrühren. Die restlichen 100 g Sahne mit Vanillinzucker und Sahnesteif steif schlagen und vorsichtig " +
                "unterheben. Für den Obstsalat verschiedene Obstsorten klein schneiden. Das geschnittene Obst mit Zitrone und etwas Orangensaft beträufeln, so werden weder Äpfel noch Bananen braun " +
                "und der Obstsalat ist somit auch auf jeden Fall 2 Tage in gut verschlossener Schüssel im Kühlschrank frisch und appetitlich haltbar.", 4, 20);
        runtimeExceptionDaoRezept.create(joghurtSahneMuesli);

        Rezept endivienSalat = new Rezept("Endiviensalat", "Endiviensalat in feine Streifen schneiden und waschen. Anschließend den Salat in warmes Wasser legen. Dadurch werden dem Salat die Bitterstoffe entzogen und er wird milder. \n" +
                "\n" +
                "In der Zwischenzeit die Zwiebel schälen und in feine Würfel schneiden. Speckwürfel ohne Fettzugabe in einer Pfanne kross braten. Für die Salatsauce alle anderen Zutaten miteinander vermischen und abschmecken. \n" +
                "Salat trocken schleudern, mit den Zwiebelwürfeln und der Salatsauce vermischen. Zum Schluss die Speckwürfel darüber geben und genießen.", 4, 20);
        runtimeExceptionDaoRezept.create(endivienSalat);

        Rezept trinkmuesli = new Rezept("Erdbeer-Trinkmüsli", "Erdbeeren waschen, trockentupfen, putzen und grob zerkleinern. Die Erdbeerstücke mit Joghurt, Milch, Vanillezucker und Haferflocken in ein " +
                "hohes Gefäß geben. Alles mit einem Stabmixer fein pürieren und als Trinkmüsli sofort servieren.", 1, 10);
        runtimeExceptionDaoRezept.create(trinkmuesli);

        Rezept enchilada = new Rezept("Enchiladas mit Hähnchen und Mais", "Das Hähnchenbrustfilet waschen und trocken tupfen. Anschließend in ca. 1 cm große Würfel schneiden. Die Paprikaschote waschen, putzen und dann ebenfalls in ca. 1 cm große Würfel schneiden. Den Knoblauch schälen und fein hacken. Die Chilischote längs aufschlitzen, entkernen und fein hacken.\n" +
                "\n" +
                "Das Öl in einer Pfanne erhitzen und darin das Fleisch und den Knoblauch rundherum anbraten. Chiliwürfel zugeben und kurz mitbraten. Tomatenmark, Paprikawürfel, Pizzatomaten und 2 EL Crème fraiche zugeben. Alles kräftig würzen, aufkochen und offen ca. 5-10 Minuten köcheln lassen.\n" +
                "\n" +
                "Die Tortillas in der Zwischenzeit erwärmen und den Backofen auf 200°C Ober-/Unterhitze (Umluft 170°C, Gas Stufe 3) vorheizen.\n" +
                "\n" +
                "Die Füllung auf die Tortillas verteilen, dabei einen Rand lassen. Von der einen Seite zur anderen aufrollen und mit der Nahtstelle nach unten in eine Auflaufform geben.\n" +
                "\n" +
                "Oregano und restliche Creme fraiche verrühren und auf die Tortillas streichen. Den Cheddarkäse grob reiben und auf die Tortillas streuen.\n" +
                "\n" +
                "Alles auf der zweiten Schiene von unten im Ofen ca. 20. Minuten überbacken.\n" +
                "\n" +
                "Noch heiß servieren..", 4, 60);
        runtimeExceptionDaoRezept.create(enchilada);

        Rezept pizzateig = new Rezept("Italienischer Pizzateig", "Alle Zutaten in eine Schüssel geben und mindestens 5 Min. gut durchkneten. Den Teig ca. 30 Min. gehen lassen. " +
                "Anschließend in 6 Portionen teilen, ausrollen und nach Belieben belegen.  Backzeit im Backofen: 220°C, ca. 15-20 Min.", 6, 60);
        runtimeExceptionDaoRezept.create(pizzateig);

        Rezept cordonBleu = new Rezept("Cordon bleu", "Auf einen Teller etwas Mehl geben, in einem tiefen Teller das Ei verquirlen und auf einen weiteren Teller die Semmelbrösel schütten. \n" +
                "Die Kalbschnitzel der Länge nach aufschneiden, aber nicht ganz durchtrennen (Schmetterlingsschnitt). Die Schnitzel zwischen Frischhaltefolie legen und mit einem schweren, FLACHEN Gegenstand, z. B. einem Topf, kräftig klopfen. Die Frischhaltefolie entfernen und je eine Scheibe Käse und Schinken hinein legen, wieder zuklappen und mit Zahnstochern feststecken. Salzen, pfeffern, gleichmäßig in Mehl wenden, durch das Ei ziehen und anschließend mit den Semmelbröseln panieren. \n" +
                "\n" +
                "Reichlich Butterschmalz in einer unbeschichteten Pfanne stark erhitzen bis es raucht, die Temperatur etwas herunterschalten und die Schnitzel von jeder Seite ca. 3 - 5 Minuten schnell braten, bis sie schön goldbraun sind.", 2, 25);
        runtimeExceptionDaoRezept.create(cordonBleu);

        Rezept rahmsoße = new Rezept("Champignon-Rahmsoße", "Champignons putzen, Stiele kürzen und vierteln. Das Olivenöl in der Pfanne heiß werden lassen und die Champignons kurz anbraten. Mit dem Wasser, Cremefine und Balsamico ablöschen und mit den Gewürzen und Kräutern abschmecken. Kurz aufkochen lassen und ein wenig reduzieren. \n" +
                "\n" +
                "Schmeckt zu Reis oder Nudeln oder auch einfach mit einem Stück Baguette oder einem Brötchen.\n" +
                "\n" +
                "Ich bevorzuge Reis und dazu noch einen Gurkensalat.", 2, 35);
        runtimeExceptionDaoRezept.create(rahmsoße);

        Rezept pfannkuchen = new Rezept("Pfannkuchen", "Die Eier trennen und das Eiweiß schaumig schlagen. Alle weiteren Zutaten außer dem Apfel in eine Schüssel geben und mit einem Mixer mischen, anschließend den Eischnee unterheben. \n" +
                "\n" +
                "Jetzt den Apfel schälen und in kleine Scheiben schneiden und zum Teig geben. Nun etwas Öl in einer Pfanne erhitzen und den Teig beidseitig ausbacken, bis der Pfannkuchen goldbraun ist. Der Apfel kann natürlich auch weggelassen werden.", 4, 25);
        runtimeExceptionDaoRezept.create(pfannkuchen);

        final RuntimeExceptionDao<Rezept_hat_Artikel, ?> runtimeExceptionDaoRezeptHasArtikel = getRuntimeExceptionDao(Rezept_hat_Artikel.class);
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(schinkenwürfel, carbonara, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelSonnenblume, carbonara, 15));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(eier, carbonara, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(sahne, carbonara, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(parmesan, carbonara, 50));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, carbonara, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, carbonara, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(spaghetti, carbonara, 200));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salat, salatGemischt, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(krebse, salatGemischt, 400));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(paprika, salatGemischt, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(kresse, salatGemischt, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(honig, salatGemischt, 25));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelOlive, salatGemischt, 4));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(balsamico, salatGemischt, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(walnuesse, salatGemischt, 50));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, salatGemischt, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, salatGemischt, 1));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(cornedBeef, labskaus, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(kartoffeln, labskaus, 0.75));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(gewuergurken, labskaus, 4));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zwiebeln, labskaus, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(roteBeete, labskaus, 4));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, labskaus, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, labskaus, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(margarine, labskaus, 20));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(eier, fantakuchen, 4));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zucker, fantakuchen, 250));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(vanillezucker, fantakuchen, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelSonnenblume, fantakuchen, 8));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(orangenlimonade, fantakuchen, 150));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mehl, fantakuchen, 250));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(backpulver, fantakuchen, 0.25));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mehl, chocolateChipCookies, 280));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(natron, chocolateChipCookies, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, chocolateChipCookies, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(butter, chocolateChipCookies, 250));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zucker, chocolateChipCookies, 190));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(braunerZucker, chocolateChipCookies, 135));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(vanillezucker, chocolateChipCookies, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(eier, chocolateChipCookies, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(schokoladeZartbitter, chocolateChipCookies, 350));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(hackfleisch, bolognese, 1000));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(knoblauch, bolognese, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(moehren, bolognese, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(staudensellerie, bolognese, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zwiebeln, bolognese, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(dosenTomaten, bolognese, 1.5));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(spaghetti, bolognese, 600));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(butter, bolognese, 125));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(milch, bolognese, 500));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(peperoncini, bolognese, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, bolognese, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, bolognese, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(huenerbruehe, bolognese, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelOlive, bolognese, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(weißwein, bolognese, 2));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelSonnenblume, flammkuchen, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(wasser, flammkuchen, 125));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, flammkuchen, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mehl, flammkuchen, 250));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zwiebeln, flammkuchen, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(schinkenwürfel, flammkuchen, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(cremeFraiche, flammkuchen, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(schmand, flammkuchen, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, flammkuchen, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(schnittlauch, flammkuchen, 1));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(hackfleisch, kaeseSuppe, 500));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(lauch, kaeseSuppe, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(schmelzkaese, kaeseSuppe, 250));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(cremeFraiche, kaeseSuppe, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(gemuesebruehe, kaeseSuppe, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(wasser, kaeseSuppe, 700));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, kaeseSuppe, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, kaeseSuppe, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelSonnenblume, kaeseSuppe, 3));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(getrockeneTomaten, pestoRosso, 150));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelOlive, pestoRosso, 10));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(knoblauch, pestoRosso, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(basilikum, pestoRosso, 20));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(parmesan, pestoRosso, 50));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pinienkerne, pestoRosso, 30));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(chilliSchoten, pestoRosso, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(rotwein, pestoRosso, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(tomatenmark, pestoRosso, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, pestoRosso, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, pestoRosso, 1));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(milch, joghurtSahneMuesli, 300));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(sahne, joghurtSahneMuesli, 600));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(joghurt, joghurtSahneMuesli, 600));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(quark, joghurtSahneMuesli, 250));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(rosinen, joghurtSahneMuesli, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zucker, joghurtSahneMuesli, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(haferflocken, joghurtSahneMuesli, 250));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(walnuesse, joghurtSahneMuesli, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(vanillezucker, joghurtSahneMuesli, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(sahnesteif, joghurtSahneMuesli, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(orange, joghurtSahneMuesli, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(apfel, joghurtSahneMuesli, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mango, joghurtSahneMuesli, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(banane, joghurtSahneMuesli, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(orangensaft, joghurtSahneMuesli, 4));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zitronensaft, joghurtSahneMuesli, 1));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(endiviensalat, endivienSalat, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zwiebeln, endivienSalat, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(schinkenwürfel, endivienSalat, 150));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(essig, endivienSalat, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelOlive, endivienSalat, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zucker, endivienSalat, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, endivienSalat, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, endivienSalat, 1));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(erdbeeren, trinkmuesli, 150));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(joghurt, trinkmuesli, 40));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(milch, trinkmuesli, 150));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(vanillezucker, trinkmuesli, 0.25));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(haferflocken, trinkmuesli, 20));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(haenchenbrustfilet, enchilada, 600));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(paprika, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mais, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(knoblauch, enchilada, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(chilliSchoten, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(tomatenmark, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(dosenTomaten, enchilada, 0.5));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(cremeFraiche, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelOlive, enchilada, 3));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(paprikapulver, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oregano, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(kaese, enchilada, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, enchilada, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, enchilada, 600));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(tortilla, enchilada, 8));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mehl, pizzateig, 500));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(hefe, pizzateig, 4));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelOlive, pizzateig, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(wasser, pizzateig, 300));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, pizzateig, 1));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(kalbsschnitzel, cordonBleu, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(kaese, cordonBleu, 50));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(kochschinken, cordonBleu, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(eier, cordonBleu, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mehl, cordonBleu, 20));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(paniermehl, cordonBleu, 20));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, cordonBleu, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, cordonBleu, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(butterschmalz, cordonBleu, 50));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(champignons, rahmsoße, 400));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(sahne, rahmsoße, 200));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(petersilie, rahmsoße, 5));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(wasser, rahmsoße, 50));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(balsamico, rahmsoße, 2));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, rahmsoße, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(pfeffer, rahmsoße, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oregano, rahmsoße, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(oelOlive, rahmsoße, 1));

        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(eier, pfannkuchen, 4));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(mehl, pfannkuchen, 400));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(wasser, pfannkuchen, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(milch, pfannkuchen, 100));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(vanillezucker, pfannkuchen, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(zucker, pfannkuchen, 200));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(apfel, pfannkuchen, 1));
        runtimeExceptionDaoRezeptHasArtikel.create(new Rezept_hat_Artikel(salz, pfannkuchen, 1));
    }

}

