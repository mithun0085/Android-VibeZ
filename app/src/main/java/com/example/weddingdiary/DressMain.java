package com.example.weddingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.weddingdiary.databinding.ActivityDressMainBinding;
import com.example.weddingdiary.databinding.ActivityHotelMainBinding;

import java.util.ArrayList;

public class DressMain extends AppCompatActivity {

    ActivityDressMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDressMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] ImageId = {R.drawable.dress1,R.drawable.dress2,R.drawable.dress3,R.drawable.dress4,R.drawable.dress5,
                R.drawable.dress6,R.drawable.dress7,R.drawable.dress8};
        String[] Name = {"White Kandyan","Pinkish Kandyan","Gold Shaded","Embroidary Saree","Silk Saree","Gold Silk","Purl Work Saree","Trad Kandyan"};
        String[] Designer = {"Ms Nuwini Athukorala","Ms Sadali Perera","Ms Sahanma Mendis","Ms Surani Dabagoda","MS Abisheka Silva",
                "Ms Sudisha Nirmali","Ms Sujani Senanayake","Ms Amani Pushpika"};
        String[] Price = {"LKR 70 000","LKR 55 000","LKR 84 000","LKR 94 000","LKR 80 000",
                "LKR 120 000","LKR 48 000","LKR 110 000"};
        String[] PhoneNo = {"+947656610000","+949999043232","+947834354323","+949876543211","+945434432343",
                "+949439043232","+947534354323","+946545543211"};
        String[] Dis = {"Designed and created by amorine from start to finish, through custom sketches, attention to details, elegant hand embellishments and made to perfection with love and care",
                "Beautiful pinkish kandyan made up for a pretty bride Bridal Designed and created by AMORINE",
                "Traditional kandyan wedding saree (Made-up).Beige colour with pearls & stones.",
                "Gold stones work saree with a long tail. Flower bouquet also available.(Above price without flower bouquet) ,Madeup kandyan with saree",
                "Beautiful stone worked lace saree designed by a well known Bridal Saree Designer",
                "You don't need to rent your wedding dress anymore. Keep it for yourself. Purchase your wedding saree from us at the most reasonable price. Special discounts Available",
                "Purple Bridal Wear Fancy Saree , Fabric : Georgette Length : 6.3 m *Unstitch blouse fabric comes with the saree • For Orders",
                "Green Shaded Wedding Saree with Heavy Work Blouse Design,High Quality Branded and Beautiful saree designs for your next wedding event."};

        ArrayList<Dress> dressArrayList = new ArrayList<>();

        for(int i = 0;i< ImageId.length;i++){

            Dress dress= new Dress(Name[i],Designer[i],Price[i],PhoneNo[i],Dis[i],ImageId[i]);
            dressArrayList.add(dress);

        }


        DressListAdapter dresslistAdapter = new DressListAdapter(DressMain.this,dressArrayList);

        binding.listview.setAdapter(dresslistAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(DressMain.this,DressActivity.class);
                i.putExtra("Name",Name[position]);
                i.putExtra("PhoneNo",PhoneNo[position]);
                i.putExtra("Dis",Dis[position]);
                i.putExtra("ImageId",ImageId[position]);
                startActivity(i);

            }
        });

    }
}