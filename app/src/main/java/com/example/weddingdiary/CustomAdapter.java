package com.example.weddingdiary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;


    private ArrayList wedding_id, wedding_guest, wedding_adults, wedding_kids;

    int position;

    CustomAdapter(Activity activity, Context context, ArrayList wedding_id,
                  ArrayList wedding_guest,
                  ArrayList wedding_adults,
                  ArrayList wedding_kids){
        this.activity = activity;
        this.context = context;
        this.wedding_id = wedding_id;
        this.wedding_guest =wedding_guest;
        this.wedding_adults = wedding_adults;
        this.wedding_kids = wedding_kids;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        this.position = position;


        holder.wedding_id_txt.setText(String.valueOf(wedding_id.get(position)));
        holder.wedding_guest_txt.setText(String.valueOf(wedding_guest.get(position)));
        holder.wedding_adults_txt.setText(String.valueOf(wedding_adults.get(position)));
        holder.wedding_kids_txt.setText(String.valueOf(wedding_kids.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(wedding_id.get(position)) );
                intent.putExtra("guest", String.valueOf(wedding_guest.get(position)) );
                intent.putExtra("adults", String.valueOf(wedding_adults.get(position)) );
                intent.putExtra("kids", String.valueOf(wedding_kids.get(position)) );

                activity.startActivityForResult(intent, 1);


            }
        });

    }

    @Override
    public int getItemCount() {
        return wedding_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView wedding_id_txt, wedding_guest_txt, wedding_adults_txt, wedding_kids_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            wedding_id_txt = itemView.findViewById(R.id.wedding_id_txt);
            wedding_guest_txt = itemView.findViewById(R.id.wedding_guest_txt);
            wedding_adults_txt = itemView.findViewById(R.id.wedding_adults_txt);
            wedding_kids_txt = itemView.findViewById(R.id.wedding_kids_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
