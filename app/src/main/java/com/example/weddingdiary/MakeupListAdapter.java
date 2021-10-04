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

public class MakeupListAdapter extends ArrayAdapter<Makeup> {


    public MakeupListAdapter(Context context, ArrayList<Makeup> makeupArrayList){

        super(context,R.layout.list_item_makeup,makeupArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Makeup makeup= getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_makeup,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.Profile_Pic);
        TextView Name = convertView.findViewById(R.id.Name);
        TextView City = convertView.findViewById(R.id.City);
        TextView Time = convertView.findViewById(R.id.Time);

        imageView.setImageResource(makeup.ImageId);
        Name.setText(makeup.Name);
        City.setText(makeup.City);
        Time.setText(makeup.Time);


        return convertView;
    }
}