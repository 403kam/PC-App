package com.example.parkup1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//Login menu and startup on app! Note: Skip if already logged in?

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        final Button button_login = findViewById(R.id.button);
        button_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText emailEditText = (EditText) findViewById(R.id.editTextTextEmailAddress);
                String email = emailEditText.getText().toString();

                EditText passwordEditText = (EditText) findViewById(R.id.editTextTextPassword);
                String  password =  passwordEditText.getText().toString().trim();

                Log.d("debug", email);
                Log.d("debug", password);
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("debug", "signInWithEmail:success");
                                    Log.d("debug", "Logged in");
                                    openDisplay();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("debug", "signInWithEmail:failure", task.getException());
                                    Log.d("debug", "Not logged in");
                                }
                            }
                        });

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
