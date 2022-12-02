package com.example.parkup1;

import android.content.Intent;
import android.media.metrics.Event;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Create extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        Button createButton = findViewById(R.id.CreateEventbutton);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editMeetingName = (EditText) findViewById(R.id.editMeetingName);
                String title = editMeetingName.getText().toString();

                EditText editMeetingDescription = (EditText) findViewById(R.id.editMeetingDescription);
                String description = editMeetingDescription.getText().toString();

                EditText  editMeetingDate = (EditText) findViewById(R.id.editMeetingDate);
                String date = editMeetingDate.getText().toString();

                EditText editMeetingTime  = (EditText) findViewById(R.id.editMeetingTime);
                String time = editMeetingTime.getText().toString();

                EditText editStreetAddress = (EditText) findViewById(R.id.editStreetAddress);
                String streetaddress = editStreetAddress.getText().toString();

                EditText  editCity = (EditText) findViewById(R.id.editCity);
                String city = editCity.getText().toString();

                EditText editZip = (EditText) findViewById(R.id.editZip);
                String zipcode = editZip.getText().toString();

                EditText editMaxParticipants = (EditText) findViewById(R.id.editMaxParticipants);
                String maxparticipants = editMaxParticipants.getText().toString();

                String creator = "sam"; // need to be able to get current user
                Integer id = 3; // need to get last entered event id number

                DatabaseReference mbase = FirebaseDatabase.getInstance().getReference();
                event Newevent = new event(title, description, date,  time, streetaddress, city, zipcode, maxparticipants, creator, id) {};
                mbase.child("users").child(id.toString()).setValue(Newevent);
                Intent intent6 = new Intent(Create.this,
                        Display.class);
                startActivity(intent6);

            }

        });
    }
}
