package com.prabhakar.validateusercredentialsandperformlogin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        email = findViewById(R.id.tvEmail);
        email.setText(getIntent().getStringExtra("email"));
    }
}