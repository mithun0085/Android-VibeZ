package com.example.weddingdiary;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DressListAdapter extends ArrayAdapter<Dress> {


    public DressListAdapter(Context context, ArrayList<Dress> dressArrayList){

        super(context,R.layout.list_item_dress,dressArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Dress dress = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_dress,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.Profile_Pic);
        TextView Name = convertView.findViewById(R.id.Name);
        TextView Designer = convertView.findViewById(R.id.Designer);
        TextView Price = convertView.findViewById(R.id.Price);

        imageView.setImageResource(dress.ImageId);
        Name.setText(dress.Name);
        Designer.setText(dress.Designer);
        Price.setText(dress.Price);


        return convertView;
    }
}