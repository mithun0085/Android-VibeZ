package com.example.androidvibez;


import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOGuest {

    private DatabaseReference databaseReference;
    public DAOGuest()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Guest.class.getSimpleName());

    }

    public Task<Void> add(Guest gst)
    {
        return databaseReference.push().setValue(gst);

    }

}
