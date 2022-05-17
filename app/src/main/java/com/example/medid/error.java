package com.example.medid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class error extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        button = (Button) findViewById(R.id.goToStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStart();
            }
        });
    }

    public void goToStart()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}