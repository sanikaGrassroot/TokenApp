package com.example.tokenapp.project.UserManagement;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tokenapp.R;


public class RegisterActivity extends AppCompatActivity {
    EditText name, email, phone, companyID, password, Confirm_password;
    Spinner companyName;
    Button register;
    Toolbar toolbar;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // setting the UP button
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.register);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //initialising the fields
        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.emailEditText);
        phone = findViewById(R.id.phoneEditText);
        companyID=findViewById(R.id.companyIDEditText);
        companyName=findViewById(R.id.companyNameSpinner);
        password=findViewById(R.id.passwordEditText);
        Confirm_password=findViewById(R.id.confirmPasswordEditText);
        register=findViewById(R.id.registerButton);


        //TODO: populate the spinner list


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: add validations and retrofit code
                Toast.makeText(getApplicationContext(),R.string.register,Toast.LENGTH_LONG).show();
                Intent intent= new Intent(RegisterActivity.this,LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


}

