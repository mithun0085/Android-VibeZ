package com.example.weddingdiary;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;



import com.example.weddingdiary.databinding.ActivityHotelBinding;
import com.example.weddingdiary.databinding.ActivityMakeupBinding;

public class MakeupActivity extends AppCompatActivity {

    ActivityMakeupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMakeupBinding.inflate(getLayoutInflater());
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