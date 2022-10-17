package com.example.parkup1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.support.v7.app.AppCompatActivity;
//Login menu and startup on app!

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_login = findViewById(R.id.button);
        button_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openDisplay();
            }

        });

        Button button_register = findViewById(R.id.button2);
        button_register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent2 = new Intent(MainActivity.this, Register.class);
                startActivity(intent2);
            }
        });

    }

    public void openDisplay() {
        Intent intent = new Intent(this, Display.class);
        startActivity(intent);
    }
}