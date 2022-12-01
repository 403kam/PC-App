package com.example.parkup1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewMeeting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmeeting);

        Intent i = getIntent();
        String id_num = i.getStringExtra("ID_NUMBER");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("events");
        DatabaseReference eventRef = rootRef.child(id_num);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String titlename = ds.child("description").getValue(String.class);
                TextView title = findViewById(R.id.viewName);
                title.setText(titlename);
                TextView addresswhole = findViewById(R.id.viewAddress);

                String street = ds.child("streetaddress").getValue(String.class);
                String city = ds.child("city").getValue(String.class);
                String state = ds.child("state").getValue(String.class);
                String zip = ds.child("zipcode").getValue(String.class);
                String addresswholename = street+" "+city+", "+state+" "+zip;

                addresswhole.setText(addresswholename);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        eventRef.addListenerForSingleValueEvent(eventListener);
    }

}
