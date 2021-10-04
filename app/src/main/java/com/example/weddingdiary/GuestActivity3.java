package com.example.weddingdiary;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GuestActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    TextView add_adults, add_kids, add_result;

    private EditText adults_input, kids_input;

    com.example.weddingdiary.MyDatabaseHelper myDB;
    ArrayList<String> wedding_id, wedding_guest, wedding_adults, wedding_kids;
    com.example.weddingdiary.CustomAdapter customAdapter;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest3);

//display calculation
        add_adults=(TextView) findViewById(R.id.add_adults);
        add_adults.setText(getIntent().getStringExtra("adult"));

        /*add_kids=(TextView) findViewById(R.id.add_kids);
        add_kids.setText(getIntent().getStringExtra("kid"));*/

        /*add_result=(TextView) findViewById(R.id.add_result);
        add_result.setText(getIntent().getStringExtra("result")); */




        /*adults_input =findViewById(R.id.add_adults);
        kids_input =findViewById(R.id.add_kids);

        String adults = getIntent().getStringExtra("keyadults");
        String kids = getIntent().getStringExtra("keykids");

        adults_input.setText(adults);
        kids_input.setText(kids);*/





        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuestActivity3.this, com.example.weddingdiary.AddActivity.class);
                startActivity(intent);

            }
        });

        myDB = new com.example.weddingdiary.MyDatabaseHelper(GuestActivity3.this);
        wedding_id = new ArrayList<>();
        wedding_guest = new ArrayList<>();
        wedding_adults = new ArrayList<>();
        wedding_kids = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new com.example.weddingdiary.CustomAdapter(GuestActivity3.this, this, wedding_id, wedding_guest, wedding_adults, wedding_kids);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(GuestActivity3.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                wedding_id.add(cursor.getString(0));
                wedding_guest.add(cursor.getString(1));
                wedding_adults.add(cursor.getString(2));
                wedding_kids.add(cursor.getString(3));

            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                com.example.weddingdiary.MyDatabaseHelper myDB = new com.example.weddingdiary.MyDatabaseHelper(GuestActivity3.this);
                myDB.deleteAllData();
                //Refresh Activity
                Intent intent = new Intent(GuestActivity3.this, GuestActivity3.class);
                startActivity(intent);
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

