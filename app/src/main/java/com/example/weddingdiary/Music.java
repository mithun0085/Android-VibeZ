package com.example.weddingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Music extends AppCompatActivity {

    Button btnorder5, btnorder6, btnorder7, btnorder8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        btnorder5 = (Button) findViewById(R.id.btnorder5);
        btnorder6 = (Button) findViewById(R.id.btnorder6);
        btnorder7 = (Button) findViewById(R.id.btnorder7);
        btnorder8 = (Button) findViewById(R.id.btnorder8);

        btnorder5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Music.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Music.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnorder6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Music.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Music.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnorder7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Music.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Music.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnorder8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Music.this,"Order received",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Music.this, HomeActivity.class);
                startActivity(intent);
            }
        });







    }
}