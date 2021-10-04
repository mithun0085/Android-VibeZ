package com.example.weddingdiary;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.weddingdiary.databinding.ActivityDressBinding;


public class DressActivity extends AppCompatActivity {

    ActivityDressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String Name = intent.getStringExtra("Name");
            String PhoneNo = intent.getStringExtra("PhoneNo");
            String Dis = intent.getStringExtra("Dis");
            int ImageId = intent.getIntExtra("ImageId",R.drawable.a);

            binding.NameProfile.setText(Name);
            binding.PhoneProfile.setText(PhoneNo);
            binding.DisProfile.setText(Dis);
            binding.ProfileImage.setImageResource(ImageId);


        }

    }
}