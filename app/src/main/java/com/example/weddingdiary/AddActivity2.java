package com.example.weddingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity2 extends AppCompatActivity {



    EditText time_input,event_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);


        time_input = (EditText) findViewById(R.id.time_input);
        event_input =  (EditText) findViewById(R.id.event_input);
        add_button= (Button) findViewById(R.id.add_button);


        add_button.setOnClickListener((view -> {



            if (time_input.length() == 0) {
                Toast.makeText(getApplicationContext(), "please input the time", Toast.LENGTH_SHORT).show();
            }

            else if(event_input.length() == 0){
                Toast.makeText(getApplicationContext(), "please input the event", Toast.LENGTH_SHORT).show();
            }

            else{

                MyDatabaseH2 myDB = new MyDatabaseH2(AddActivity2.this);
                myDB.addEvent(time_input.getText().toString().trim(),
                        event_input.getText().toString().trim());
            }

        }));
    }
}