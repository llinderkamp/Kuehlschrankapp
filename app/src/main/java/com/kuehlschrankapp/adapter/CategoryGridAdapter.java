package com.kuehlschrankapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuehlschrankapp.R;
import com.kuehlschrankapp.db.dto.impl.Kategorie;

import java.util.List;

/**
 * Created by laj on 02.03.2015.
 * Adapter, um im GridView Icon plus Text anzuzeigen
 */
public class CategoryGridAdapter extends BaseAdapter {
    Context context;
    private List<Kategorie> categoryList;
    private LayoutInflater inflater;

    public CategoryGridAdapter(Context c,  List<Kategorie> categoryList) {
        context = c;
        this.categoryList = categoryList;
        inflater = LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return categoryList.size();
    }
    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.grid_item, parent, false);
        ImageView imageview = (ImageView) convertView.findViewById(R.id.ivGridItem);
        TextView textview = (TextView) convertView.findViewById(R.id.tvGridItem);
        textview.setText(categoryList.get(position).getName());
        imageview.setImageResource(context.getResources().getIdentifier(categoryList.get(position).getIconName(), "drawable",
                context.getPackageName()));
        return convertView;
    }
}
