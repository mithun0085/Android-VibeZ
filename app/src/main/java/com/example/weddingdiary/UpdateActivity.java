package com.example.weddingdiary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText guest_input, adults_input, kids_input;
    Button update_button, delete_button;

    String id, guest, adults, kids;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        guest_input = findViewById(R.id.guest_input2);
        adults_input = findViewById(R.id.adults_input2);
        kids_input = findViewById(R.id.kids_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(guest);
        }
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity.this, com.example.weddingdiary.GuestActivity3.class);
                startActivity(intent);

                com.example.weddingdiary.MyDatabaseHelper myDB = new com.example.weddingdiary.MyDatabaseHelper(UpdateActivity.this);
                guest = guest_input.getText().toString().trim();
                adults = adults_input.getText().toString().trim();
                kids = kids_input.getText().toString().trim();
                myDB.updateData(id, guest, adults, kids);

            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();


            }
        });

    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("guest") &&
                getIntent().hasExtra("adults") && getIntent().hasExtra("kids")) {
            //Getting Date from Intent
            id = getIntent().getStringExtra("id");
            guest = getIntent().getStringExtra("guest");
            adults = getIntent().getStringExtra("adults");
            kids = getIntent().getStringExtra("kids");

            //Setting Intent Data
            guest_input.setText(guest);
            adults_input.setText(adults);
            kids_input.setText(kids);


        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + guest + " ?");
        builder.setMessage("Are you sure you want to delete " + guest + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(UpdateActivity.this, com.example.weddingdiary.GuestActivity3.class);
                startActivity(intent);
                com.example.weddingdiary.MyDatabaseHelper myDB = new com.example.weddingdiary.MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOnRow(id);
                finish();
            }

        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();

    }
}