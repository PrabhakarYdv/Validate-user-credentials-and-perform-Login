package com.prabhakar.validateusercredentialsandperformlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText email;
    private EditText password;
    private final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.btnLogin);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emailValid = isEmailValid();
                boolean passwordValid = isPasswordValid();
                if (emailValid && passwordValid) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("email", email.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isEmailValid() {
        if (email.getText().toString().matches(emailPattern)) {
            return true;
        } else {
            email.setError("Email is invalid!");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (password.getText().length() >= 6) {
            return true;
        } else {
            password.setError("Invalid Password!");
            return false;
        }
    }
}