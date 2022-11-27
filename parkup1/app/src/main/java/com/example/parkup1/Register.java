package com.example.parkup1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        FirebaseAuth mAuth;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mAuth = FirebaseAuth.getInstance();
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText emailedittext = (EditText) findViewById(R.id.editRegisterEmail);
                String registeremail = emailedittext.getText().toString();
                EditText passwordedittext = (EditText) findViewById(R.id.editRegisterPassword);
                String registerpassword = passwordedittext.getText().toString();
                Log.d("debug", registeremail);
                Log.d("debug", registerpassword);
                mAuth.createUserWithEmailAndPassword(registeremail, registerpassword)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("debug", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                    Intent intent6 = new Intent(Register.this,
                                            MainActivity.class);
                                    startActivity(intent6);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("debug", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });

            }
        });
    }

    private void updateUI(Object o) {
    }
}
