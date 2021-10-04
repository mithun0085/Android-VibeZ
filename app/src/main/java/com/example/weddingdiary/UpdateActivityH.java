package com.example.weddingdiary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivityH extends AppCompatActivity {

    EditText time_input, event_input;
    Button update_button,delete_button;
    String id, time, event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_h);


        time_input = findViewById(R.id.time_input2);
        event_input = findViewById(R.id.event_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();


        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(time);
        }





        update_button.setOnClickListener((view) ->  {

            MyDatabaseH2 myDB = new MyDatabaseH2(UpdateActivityH.this);
                time = time_input.getText().toString().trim();
                event = event_input.getText().toString().trim();
                myDB.updateData(id, time, event);


        });


        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             confirmDialog();

            }
        });

    }






    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("time") &&
                getIntent().hasExtra("event")) {
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            time = getIntent().getStringExtra("time");
            event = getIntent().getStringExtra("event");


            //Setting Intent Data
            time_input.setText(time);
            event_input.setText(event);


        } else {

            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();

        }
    }



    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + time + " ?");
        builder.setMessage("Are you sure you want to delete " + time + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseH2 myDB = new MyDatabaseH2(UpdateActivityH.this);
                myDB.deleteOneRow(id);
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
