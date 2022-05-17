package com.example.medid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private Button login;
    private Button forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = findViewById(R.id.loginEmail);
        final EditText password = findViewById(R.id.loginPassword);
        final TextView error = findViewById(R.id.loginErrorAlert);

        login = (Button) findViewById(R.id.loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String emailInput = email.getText().toString();
                final String passwordInput = email.getText().toString();

                goToError();
            }
        });

        forgotPassword = (Button) findViewById(R.id.passwordReset);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToError();
            }
        });
    }

    public void goToError()
    {
        Intent intent = new Intent(this, error.class);
        startActivity(intent);
    }
}