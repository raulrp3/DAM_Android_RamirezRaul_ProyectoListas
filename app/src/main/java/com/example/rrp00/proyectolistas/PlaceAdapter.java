package com.example.rrp00.proyectolistas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class PlaceAdapter extends ArrayAdapter<Place> {
    public PlaceAdapter(@NonNull Context context, List<Place> objects){
        super(context,0,objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater infalter = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = infalter.inflate(R.layout.activity_item,parent,false);
        }

        TextView etPlace = convertView.findViewById(R.id.place_et_list);
        final Place item = getItem(position);

        etPlace.setText(item.getName());

        Button btnDelete = convertView.findViewById(R.id.delete_button);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(item);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

}
