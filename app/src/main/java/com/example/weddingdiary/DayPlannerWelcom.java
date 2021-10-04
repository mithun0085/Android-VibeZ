package com.example.weddingdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DayPlannerWelcom extends AppCompatActivity {


    Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_planner_welcom);

        next_button = findViewById(R.id.add_button);
        next_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(DayPlannerWelcom.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}