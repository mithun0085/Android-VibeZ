package com.example.androidvibez;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_guest_family = findViewById(R.id.edit_guest_family);
        final EditText edit_no_of_adults = findViewById(R.id.edit_no_of_adults);
        final EditText edit_no_of_kids = findViewById(R.id.edit_no_of_kids);
        Button btn = findViewById(R.id.btn_save);
        DAOGuest dao = new DAOGuest();
        btn.setOnClickListener(v->
        {
            Guest gst = new Guest(edit_guest_family.getText().toString(),edit_no_of_adults.getText().toString(),edit_no_of_kids.getText().toString());
            dao.add(gst).addOnSuccessListener(suc->
                    {




                    }


                    );

        });
    }
}