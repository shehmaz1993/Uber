package com.example.applikeuber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DriverLogInActivity extends AppCompatActivity {
    private EditText email, password;
    private Button  Login,Registration;
    FirebaseAuth nAuth;
    FirebaseAuth.AuthStateListener firebaseAuthstateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_log_in);
        nAuth = FirebaseAuth.getInstance();
        firebaseAuthstateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Intent intent=new Intent(DriverLogInActivity.this,.class);
                    startActivity(intent);
                    finish();
                    return;

                }
            }
        };
        email=(EditText)findViewById(R.id.emailid);
        password=(EditText)findViewById(R.id.password);
        Login=(Button)findViewById(R.id.login);
        Registration=(Button)findViewById(R.id.registration);
        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}