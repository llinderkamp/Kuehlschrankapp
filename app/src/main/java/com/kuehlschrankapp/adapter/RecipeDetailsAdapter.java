package com.kuehlschrankapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kuehlschrankapp.R;
import com.kuehlschrankapp.db.dto.impl.Rezept_hat_Artikel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by laj on 09.03.2015.
 * Adapter, um die Zutaten des jeweiligen Rezepts mit Menge und Einheit anzuzeigen
 */
public class RecipeDetailsAdapter extends ArrayAdapter<Rezept_hat_Artikel> {
    private final Context context;
    private List<Rezept_hat_Artikel> ingredientList;
    private int portionenAnzahl;

    public RecipeDetailsAdapter(Context context, List<Rezept_hat_Artikel> objects, int portionenAnzahl) {
        super(context, R.layout.recipe_details_item, objects);
        this.context = context;
        this.ingredientList = new ArrayList<>();
        this.ingredientList.addAll(objects);
        this.portionenAnzahl = portionenAnzahl;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.recipe_details_item, null);

            holder = new ViewHolder();
            holder.tvMenge = (TextView) convertView.findViewById(R.id.tvMenge);
            holder.tvEinheit = (TextView) convertView.findViewById(R.id.tvEinheit);
            holder.tvName = (TextView) convertView.findViewById(R.id.tvZutatName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Rezept_hat_Artikel rezeptHatArtikel = ingredientList.get(position);
        holder.tvMenge.setText((String.valueOf(rezeptHatArtikel.getMenge() / rezeptHatArtikel.getRezept().getPortionen() * portionenAnzahl)));
        holder.tvEinheit.setText(rezeptHatArtikel.getArtikel().getEinheitKochen().toString());
        holder.tvName.setText(rezeptHatArtikel.getArtikel().toString());

        return convertView;
    }

}
