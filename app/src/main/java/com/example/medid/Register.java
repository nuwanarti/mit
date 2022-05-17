package com.example.medid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    private Button register;
    private Button terms;
    DatabaseReference database = FirebaseDatabase
            .getInstance().getReferenceFromUrl("https://medid-74fba-default-rtdb.europe-west1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText email = findViewById(R.id.registereEmail);
        final EditText password = findViewById(R.id.registerPassword);
        final EditText name = findViewById(R.id.registerName);
        final EditText passConfirmation = findViewById(R.id.registerConfirmPassword);
        final TextView error = findViewById(R.id.registerConfirmPassword);


        register = (Button) findViewById(R.id.registerBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String emailInput = email.getText().toString();
                final String nameInput = email.getText().toString();
                final String passwordInput = email.getText().toString();
                final String passConfirmInput = email.getText().toString();
                checkFields(emailInput, nameInput, passwordInput, passConfirmInput);
                // goToError();
            }
        });

        terms = (Button) findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
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

    public void checkFields(String email, String name, String password, String passConfirm)
    {
        if(email.isEmpty() || name.isEmpty() || password.isEmpty() || passConfirm.isEmpty())
        {
            // show error text
        }
        else if(password.equals(passConfirm))
        {
            // show error
        }
        else
        {
            database.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot.hasChild(email))
                    {
                        // show error
                    }
                    else
                    {
                        database.child("users").child(name).child("email").setValue(email);
                        database.child("users").child(name).child("password").setValue(password);
                        database.child("users").child(name).child("name").setValue(name);
                        finish();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });




        }
    }
}