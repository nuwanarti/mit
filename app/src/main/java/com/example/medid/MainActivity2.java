package com.example.medid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private Button signUp;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        signUp = (Button) findViewById(R.id.register);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });

        logIn = (Button) findViewById(R.id.login);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogIn();
            }
        });

    }

    public void openSignUp()
    {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void openLogIn()
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void goToError()
    {
        Intent intent = new Intent(this, error.class);
        startActivity(intent);
    }
}