package com.example.tokenapp.project.UserManagement;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tokenapp.R;


public class ProfileActivity extends AppCompatActivity {
    TextView name,email,phone,company_name,company_id;
    ImageView photo;
    Toolbar toolbar;
    ActionBar actionBar;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // setting the UP button
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.profile);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        name=findViewById(R.id.nameTextView);
        email=findViewById(R.id.emailTextView);
        phone=findViewById(R.id.phoneTextView);
        company_name=findViewById(R.id.companyTextView);
        company_id=findViewById(R.id.companyIDTextView);
        photo=findViewById(R.id.userPhoto);
        floatingActionButton=findViewById(R.id.fabImage);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:add photo from gallery or camera
            }
        });





    }
}
