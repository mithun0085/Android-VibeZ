package com.example.weddingdiary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText guest_input, adults_input, kids_input;
    TextView add_result, add_adults, add_kids ;
    Button add_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        guest_input = findViewById(R.id.guest_input);
        adults_input = findViewById(R.id.adults_input);
        kids_input = findViewById(R.id.kids_input);
        add_button = findViewById(R.id.add_button);
        add_result = findViewById(R.id.add_result);



//        adults_input.addTextChangedListener(textWatcher);
//        kids_input.addTextChangedListener(textWatcher);




        add_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (guest_input.length() == 0) {
                    Toast.makeText(getApplicationContext(), "please input the time", Toast.LENGTH_SHORT).show();
                } else if (adults_input.length() == 0) {
                    Toast.makeText(getApplicationContext(), "please input the event", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AddActivity.this, GuestActivity3.class);
                    startActivity(intent);
                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                    myDB.addGuest(guest_input.getText().toString().trim(),
                            Integer.valueOf(adults_input.getText().toString().trim()),
                            Integer.valueOf(kids_input.getText().toString().trim()));



                    String adults = adults_input.getText().toString();
                    Intent intent1 = new Intent(AddActivity.this, GuestActivity3.class);
                    intent1.putExtra("adult", adults);
                    startActivity(intent1);

                    /*String kids = kids_input.getText().toString();
                    Intent intent2 = new Intent(AddActivity.this, GuestActivity3.class);
                    intent1.putExtra("kid", kids);
                    startActivity(intent2);*/

                  /*  String results =add_result.setText(String.valueOf(adults + kids));
                    Intent intent3 = new Intent(AddActivity.this, GuestActivity3.class);
                    intent1.putExtra("result", results);
                    startActivity(intent3); */








               /*TextWatcher textWatcher = new TextWatcher() {

                    String adults = adults_input.getText().toString();
                    String kids = kids_input.getText().toString();

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        if (!adults_input.getText().toString().equals("") && !kids_input.getText().toString().equals("")) {
                            adults = adults + Integer.parseInt(adults_input.getText().toString());
                            kids = kids + Integer.parseInt(kids_input.getText().toString());

                            Intent intent = new Intent(AddActivity.this, GuestActivity3.class);
                            intent.putExtra("keyadults", adults);
                            intent.putExtra("keykids", kids);
                            startActivity(intent);

                            //add_result.setText(String.valueOf(adults + kids));

//                    int temp1= Integer.parseInt(adults_input.getText().toString());
//                    int temp2= Integer.parseInt(kids_input.getText().toString());

//                    add_button.setText((String.valueOf(adults + kids)));

                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {



                }; */
            }

            }
        });


    }


}
