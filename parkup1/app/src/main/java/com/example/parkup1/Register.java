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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.charset.StandardCharsets;

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
                String registeremail = emailedittext.getText().toString().trim();

                EditText passwordedittext = (EditText) findViewById(R.id.editRegisterPassword);
                String registerpassword = passwordedittext.getText().toString();

                EditText nameEditText = (EditText) findViewById(R.id.editName);
                String registerName = nameEditText.getText().toString();

                EditText registerconfirmEmail = (EditText) findViewById(R.id.editRegisterConfirmEmail);
                String confirmEmail = registerconfirmEmail.getText().toString();

                EditText registerConfirmPassword = (EditText) findViewById(R.id.editRegisterConfirmPassword);
                String confirmPassword = registerConfirmPassword.getText().toString();

                mAuth.createUserWithEmailAndPassword(registeremail, registerpassword)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("debug", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();


                                    FirebaseDatabase rootnode;
                                    DatabaseReference reference;
                                    rootnode = FirebaseDatabase.getInstance();
                                    reference = rootnode.getReference("users");

                                    userHelper helper = new userHelper(registerName,registeremail,confirmEmail,registerpassword,confirmPassword);
                                    reference.child(registerName).setValue(helper);

                                    Intent intent6 = new Intent(Register.this, MainActivity.class);
                                    startActivity(intent6);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("debug", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
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
