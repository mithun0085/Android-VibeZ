package com.example.weddingdiary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class invitationCalc extends AppCompatActivity {
    List<Model2> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation_calc);


        // creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model2("Luxury Invitation Card Design", getString(R.string.luxury), R.drawable.invi1 ));
        modelList.add(new Model2("Semi Luxury Invitation Card Design", getString(R.string.semiluxury), R.drawable.invi2));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);



    }
}