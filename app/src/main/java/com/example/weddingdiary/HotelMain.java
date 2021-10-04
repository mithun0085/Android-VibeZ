package com.example.weddingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;



import com.example.weddingdiary.databinding.ActivityHotelMainBinding;

import java.util.ArrayList;

public class HotelMain extends AppCompatActivity {

    ActivityHotelMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] ImageId = {R.drawable.hotel1,R.drawable.hotel2,R.drawable.hotel3,R.drawable.hotel4,R.drawable.hotel5,
                R.drawable.hotel6,R.drawable.hotel7,R.drawable.hotel8};
        String[] Name = {"Lavanya","Heritance","Jetwin Lagoon","The Grand hotel","Hilton Hotel","Sons","Araliya","Jetwing Sea"};
        String[] City = {"Colombo7","Negombo","Negombo","Kandy","Colombo 2",
                "Kurunegala","Kandy","Negombo"};
        String[] Time = {"Opens 6.00AM","Opens 6.30AM","Opens 7.00AM","Opens 6:32AM","Opens 5:76AM",
                "Opens 5:00AM","Opens 7:34AM","Opens 7:32AM"};
        String[] PhoneNo = {"+947656610000","+949999043232","+947834354323","+949876543211","+945434432343",
                "+949439043232","+947534354323","+946545543211"};
        String[] Dis = {"Lavanya Hotel, Colombo offers some of the finest accommodation in the country and wedding event space catering to up to 2,000 guests.",
                "If you’re looking for a luxury hotel in rathnapura, look no further than Heritance Negombo.For those interested in checking out popular landmarks while visiting Negombo, Heritance Negombo is located a short distance from Negombo Public Cemetery (0.3 mi) and Dutch Clock Tower (0.8 mi).",
                "Jetwing Lagoon, an architectural masterpiece designed by the world-renowned Sri Lankan Architect, Geoffrey Bawa and wedding event space catering to up to 2,000 guests",
                "Situated in the heart of City of Kandy, The Grand Kandyan five -star luxury hotel is the perfect heaven for those with time to explore Kandyan warm hospitality and diverse cultures. Just 10 minutes from ‘ Sri Dalada Maligawa’, The Temple of the Sacred Tooth Relic of Buddha which is the most popular attraction in UNESCO World Heritage City,Kandy",
                "Since its beginnings in 1864 The Galle Face Hotel has been part of Colombo heritage, catering to world travellers, the property stands as one of the most storied hotels in Asia. Oozing history from every pore, timeless traditions and character abounds in each of our 156 guestrooms, restored to reflect the Galle Face Hotel’s rich past.",
                "An unspoiled personal tropical paradise on the southern coast of Sri Lanka. Our spacious rooms create a sense of privacy and relaxation, Famous for wedding photo shoots",
                "An unspoiled personal tropical paradise on the southern coast of Sri Lanka. Our spacious wedding halls create a sense of relaxation",
                "With the beach at your doorstep, Jetwing Sea offers an idyllic coastal retreat along the soft golden sands of Negombo and makes for an enchanting holiday home where one can work, play and fall in love."};

        ArrayList<Hotel> hotelArrayList = new ArrayList<>();

        for(int i = 0;i< ImageId.length;i++){

            Hotel hotel = new Hotel(Name[i],City[i],Time[i],PhoneNo[i],Dis[i],ImageId[i]);
            hotelArrayList.add(hotel);

        }


        HotelListAdapter hotellistAdapter = new HotelListAdapter(HotelMain.this,hotelArrayList);

        binding.listview.setAdapter(hotellistAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(HotelMain.this,HotelActivity.class);
                i.putExtra("Name",Name[position]);
                i.putExtra("PhoneNo",PhoneNo[position]);
                i.putExtra("Dis",Dis[position]);
                i.putExtra("ImageId",ImageId[position]);
                startActivity(i);

            }
        });

    }
}