package com.example.weddingdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BudgetMenu3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_menu3);
    }



    public void btnPhotography(View view) {
        Intent intent = new Intent(this, photography2.class);
        startActivity(intent);
    }

    public void btnHotels(View view) {
        Intent intent = new Intent(this, HotelMain.class);
        startActivity(intent);
    }

    public void btnVehicle(View view) {
        Intent intent = new Intent(this, vehicle.class);
        startActivity(intent);
    }

    public void btnMusic(View view) {
        Intent intent = new Intent(this, Music.class);
        startActivity(intent);
    }

    public void btnMakeup(View view) {
        Intent intent = new Intent(this, MakeupMain.class);
        startActivity(intent);
    }

    public void btnInvitation(View view) {
        Intent intent = new Intent(this, invitationCalc.class);
        startActivity(intent);
    }


    public void btnDecoration(View view) {
        Intent intent = new Intent(this, decoration.class);
        startActivity(intent);
    }

    public void btnDress(View view) {
        Intent intent = new Intent(this, DressMain.class);
        startActivity(intent);
    }
}