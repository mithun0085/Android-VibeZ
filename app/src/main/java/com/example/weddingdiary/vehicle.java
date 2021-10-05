package com.example.weddingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class vehicle extends AppCompatActivity {

    Button btnorder1, btnorder2, btnorder3, btnorder4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        btnorder1 = (Button) findViewById(R.id.btnorder1);
        btnorder2 = (Button) findViewById(R.id.btnorder2);
        btnorder3 = (Button) findViewById(R.id.btnorder3);
        btnorder4 = (Button) findViewById(R.id.btnorder4);

        btnorder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(vehicle.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(vehicle.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnorder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(vehicle.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(vehicle.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnorder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(vehicle.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(vehicle.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnorder4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(vehicle.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(vehicle.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}