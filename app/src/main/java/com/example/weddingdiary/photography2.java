package com.example.weddingdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class photography2 extends AppCompatActivity {
    Button buttonGeeshan;
    Button buttonRasanga;
    Button buttonDinesh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photography2);
        buttonGeeshan = findViewById(R.id.buttonGeeshan);
        buttonGeeshan.setOnClickListener(view -> {
            Intent intent = new Intent(photography2.this, photography1.class);
            startActivity(intent);
        });
        buttonRasanga = findViewById(R.id.buttonRasanga);
        buttonRasanga.setOnClickListener(view -> {
            Intent intent = new Intent(photography2.this, photography3.class);
            startActivity(intent);
        });
        buttonDinesh = findViewById(R.id.buttonDinesh);
        buttonDinesh.setOnClickListener(view -> {
            Intent intent = new Intent(photography2.this, photography4.class);
            startActivity(intent);
        });
    }
}