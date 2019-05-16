package com.example.tokenapp.project.OrderManagement;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tokenapp.R;

public class GenerateOrder extends AppCompatActivity {
    ActionBar actionBar;
    Toolbar toolbar;
    TextView userName;
    Spinner customer,product;
    Button generateOrder;
    ImageView qrGenerated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_order);
        // setting the UP button
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.generate_order);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        userName=findViewById(R.id.ViewUserName);
        customer=findViewById(R.id.customerSpinner);
        product=findViewById(R.id.productSpinner);
        generateOrder=findViewById(R.id.generateOrderButton);
        qrGenerated=findViewById(R.id.generatedImage);

        generateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
