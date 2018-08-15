package com.cam.listpersonalizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MiAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Item> list;
    public MiAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.context=context;
        this.list=objects;
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=
                LayoutInflater.from(parent.getContext())
                        .inflate(this.resource,parent,false);
        TextView tvNombre=
                (TextView)convertView.findViewById(R.id.tvNombre);
        TextView tvNumero=
                (TextView)convertView.findViewById(R.id.tvNumero);
        ImageView ivImagen=
                (ImageView)convertView.findViewById(R.id.ivImagen);

        tvNombre.setText(list.get(position).getNombre());
        tvNumero.setText(String.valueOf(list.get(position).getNumero()));
        ivImagen.setImageResource(list.get(position).getImagen());

        return convertView;
    }
}
