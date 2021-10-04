package com.example.weddingdiary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomerAdapterH  extends RecyclerView.Adapter<CustomerAdapterH.MyViewHolderH>{

    private Context context;

  Activity activity;


    private ArrayList event_id, event_time, event;
    Animation translate_anim2;


    CustomerAdapterH(Activity activity, Context context, ArrayList event_id, ArrayList event_time, ArrayList event){
         this.activity=activity;
        this.context = context;
        this.event_id= event_id;
        this.event_time = event_time;
        this.event = event;



    }
    @NonNull

    @Override
    public MyViewHolderH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, parent, false);
        return new MyViewHolderH(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderH holder,final int position) {




        holder.event_id_txt.setText(String.valueOf(event_id.get(position)));
        holder.event_time_txt.setText(String.valueOf(event_time.get(position)));
        holder.event_txt.setText(String.valueOf(event.get(position)));

        holder.mainLayout.setOnClickListener(view ->  {

            Intent intent = new Intent(context, UpdateActivityH.class);
            intent.putExtra("id", String.valueOf(event_id.get(position)));
            intent.putExtra("time", String.valueOf(event_time.get(position)));
            intent.putExtra("event", String.valueOf(event.get(position)));

            activity.startActivityForResult(intent,1);



        });
    }
    @Override
    public int getItemCount() {
        return event_id.size();
    }

     class MyViewHolderH extends RecyclerView.ViewHolder {

        TextView event_id_txt, event_time_txt, event_txt;
        LinearLayout mainLayout;

     MyViewHolderH(@NonNull View itemView) {
            super(itemView);
            event_id_txt = itemView.findViewById(R.id.event_id_txt);
            event_time_txt = itemView.findViewById(R.id.event_time_txt);
            event_txt = itemView.findViewById(R.id.event_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);


         Animation translate_anim2 = AnimationUtils.loadAnimation(context, R.anim.translate_anim2);
         mainLayout.setAnimation(translate_anim2);


     }
    }
}