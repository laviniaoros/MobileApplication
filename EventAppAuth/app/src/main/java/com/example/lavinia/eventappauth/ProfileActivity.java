package com.example.lavinia.eventappauth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewProfile= (TextView) findViewById(R.id.textViewProfile);
        textViewProfile.setText(getIntent().getExtras().getString("Email"));
    }
}
