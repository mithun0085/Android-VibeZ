package com.example.weddingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weddingdiary.Utils.DBHelper;

import org.w3c.dom.Text;


public class MainActivity3 extends AppCompatActivity {

    EditText username, password, repassword, age, email;
    Button signup, signin;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String ag = age.getText().toString();
                String emai = email.getText().toString();
                validateEmailAddress(email);

                if(user.equals("")||pass.equals("")||repass.equals("")||ag.equals("")||emai.equals(""))
                    Toast.makeText(MainActivity3.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass, ag, emai);
                            if(insert==false){
                                Toast.makeText(MainActivity3.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);


                            }else{
                                Toast.makeText(MainActivity3.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity3.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity3.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });


    }

    private boolean validateEmailAddress(EditText email){
        String emailInput = email.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(MainActivity3.this, "Email Validated Succsessfully!",Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(MainActivity3.this,"Invalid Email Address!",Toast.LENGTH_SHORT).show();
            return true;
        }
    }





}