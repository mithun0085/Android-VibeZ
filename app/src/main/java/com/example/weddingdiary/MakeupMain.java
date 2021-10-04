package com.example.weddingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;



import com.example.weddingdiary.databinding.ActivityMakeupMainBinding;

import java.util.ArrayList;

public class MakeupMain extends AppCompatActivity {

    ActivityMakeupMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMakeupMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] ImageId = {R.drawable.makeup1,R.drawable.makeup2,R.drawable.makeup3,R.drawable.makeup4,R.drawable.makeup5,
                R.drawable.makeup6,R.drawable.makeup7,R.drawable.makeup8};
        String[] Name = {"MS Sajana Perera","MS Rithu Batagoda","MS Sandali Silva","MS Tesara Gamage","MS Anu Wagama","MS Dil Hettige","MS Buwi Weligama","MS Sany Fernando"};
        String[] City = {"Colombo7","Negombo","Negombo","Kandy","Colombo 2",
                "Kurunegala","Kandy","Negombo"};
        String[] Time = {"MON-SAT","MON-FRI","MON-FRI","MON-FRI","MON-SAT",
                "MON-FRI","MON-FRI","MON-SAT"};
        String[] PhoneNo = {"+947656610000","+949999043232","+947834354323","+949876543211","+945434432343",
                "+949439043232","+947534354323","+946545543211"};
        String[] Dis = {"Professional bridal makeup and hair dressing and  party make-up  ,quality products, different type mahendi systl  form indea and Arabic ,bridal bouquet and jewelerys excellent services dimple's studio",
                "Professional. Convenient hours. Quality products. Best place to bridal and party makeup , beautiful bridal jewelry, reasonable prices and excellent services",
                "Based In Colombo. Qualified With Cosmetic Management & Esthetician Certifications From Canadian... 20 Albert Place, Dehiwela, Sri Lanka.",
                "Best place to have a bridal makeup, airbrush makeup, studio makeup, HD makeup,hair styling, nail arts and skin care!",
                "step by step (KANDYAN BRIDAL MKEUP ), Bridal , Hair and Beauty Salon Bridal Dressing Saree Draping Facial Treatments • Normal Facials • Aroma Facials • Gold Facials • Silver Facials",
                "Bridal , Hair and Beauty Salon Bridal Dressing Saree Draping Facial Treatments • Normal Facials • Aroma Facials • Gold Facials • Silver Facials",
                "Sana is an amazing makeup artist from Delhi, with the talent to transform you into a beaut in you special day.",
                "A perfect place where they provide all types of mehandi designs and makeup with the best price"};

        ArrayList<Makeup> makeupArrayList = new ArrayList<>();

        for(int i = 0;i< ImageId.length;i++){

            Makeup makeup = new Makeup(Name[i],City[i],Time[i],PhoneNo[i],Dis[i],ImageId[i]);
            makeupArrayList.add(makeup);

        }


       MakeupListAdapter makeuplistAdapter = new MakeupListAdapter(MakeupMain.this,makeupArrayList);

        binding.listview.setAdapter(makeuplistAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MakeupMain.this,MakeupActivity.class);
                i.putExtra("Name",Name[position]);
                i.putExtra("PhoneNo",PhoneNo[position]);
                i.putExtra("Dis",Dis[position]);
                i.putExtra("ImageId",ImageId[position]);
                startActivity(i);

            }
        });

    }
}