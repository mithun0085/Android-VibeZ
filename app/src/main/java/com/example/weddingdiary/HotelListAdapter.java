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

public class HotelListAdapter extends ArrayAdapter<Hotel> {


 public HotelListAdapter(Context context, ArrayList<Hotel> hotelArrayList){

  super(context,R.layout.list_item_hotel,hotelArrayList);

 }

 @NonNull
 @Override
 public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

  Hotel hotel = getItem(position);

  if (convertView == null){

   convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_hotel,parent,false);

  }

  ImageView imageView = convertView.findViewById(R.id.Profile_Pic);
  TextView Name = convertView.findViewById(R.id.Name);
  TextView City = convertView.findViewById(R.id.City);
  TextView Time = convertView.findViewById(R.id.Time);

  imageView.setImageResource(hotel.ImageId);
  Name.setText(hotel.Name);
  City.setText(hotel.City);
  Time.setText(hotel.Time);


  return convertView;
 }
}