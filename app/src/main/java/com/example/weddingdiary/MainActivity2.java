package com.example.weddingdiary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseH2 myDB;
    ArrayList<String> event_id, event_time, event;

    CustomerAdapterH customerAdapterH;


    TextView no_data1;
    ImageView empty_imageview;


    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());


        recyclerView = findViewById(R.id.recycleView);
            add_button= findViewById(R.id.add_button);

        no_data1 = findViewById(R.id.no_data1);
        empty_imageview = findViewById(R.id.empty_imageview);

            add_button.setOnClickListener(view ->  {


                    Intent intent = new Intent(MainActivity2.this, AddActivity2.class);
                    startActivity(intent);


            });


        myDB = new MyDatabaseH2(MainActivity2.this);
        event_id = new ArrayList<>();
        event_time = new ArrayList<>();
        event = new ArrayList<>();

        storeDataInArrays();



        customerAdapterH = new CustomerAdapterH(MainActivity2.this,this, event_id, event_time, event);
        recyclerView.setAdapter(customerAdapterH);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));

        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            no_data1.setVisibility(View.VISIBLE);
            empty_imageview.setVisibility(View.VISIBLE);

        } else {
            while (cursor.moveToNext()) {
                event_id.add(cursor.getString(0));
                event_time.add(cursor.getString(1));
                event.add(cursor.getString(2));

            }

            empty_imageview.setVisibility(View.GONE);
            no_data1.setVisibility(View.GONE);

        }
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.my_menu2, menu);
            return super.onCreateOptionsMenu(menu);
        }


        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            if (item.getItemId() == R.id.delete_all) {
                confirmDialog();
            }
            return super.onOptionsItemSelected(item);
        }
        void confirmDialog () {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Delete All?");
            builder.setMessage("Are you sure you want to delete all Data?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MyDatabaseH2 myDB = new MyDatabaseH2(MainActivity2.this);
                    myDB.deleteAllData();
                    //Refresh Activity
                    Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
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




    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        ;

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }






    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}

