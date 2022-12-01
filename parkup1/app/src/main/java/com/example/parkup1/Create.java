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
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance("http://pc-app-c9b34-default-rtdb.firebaseio.com");
    private DatabaseReference mDatabase= FirebaseDatabase.getInstance("http://pc-app-c9b34-default-rtdb.firebaseio.com").getReference();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

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

                FirebaseUser currentUser = mAuth.getCurrentUser();
                String creator = "sam";//currentUser.getDisplayName();
                Integer id = 3;
                event Newevent = new event(title, description, date,  time, streetaddress, city, zipcode, maxparticipants, creator, id) {};

                //mDatabase.child("events").child(Newevent.getId().toString()).push().setValue(Newevent);

                 mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent);

               /* mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getDescription());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getDate());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getTime());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getStreetaddress());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getCity());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getZipcode());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getMaxparticipants());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getCreator());
                mDatabase.child("events").child(Newevent.getId().toString()).setValue(Newevent.getId());*/
                Intent intent6 = new Intent(Create.this,
                        Display.class);
                startActivity(intent6);

            }

        });
    }
}
