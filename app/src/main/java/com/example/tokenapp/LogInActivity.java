package com.example.tokenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user,password;
    TextView register,forgot_password;
    Button logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        user=findViewById(R.id.email_phone_EditText_LogIn);
        password=findViewById(R.id.password_EditText_LogIn);
        register=findViewById(R.id.registerTextView);
        forgot_password=findViewById(R.id.forgotPasswordTextView);
        logIn=findViewById(R.id.LogInButton);

    }

    @Override
    public void onClick(View v) {
        if(v==logIn){
            Intent intent= new Intent(LogInActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (v==register){
            Intent intent= new Intent(LogInActivity.this,MainActivity.class);
            startActivity(intent);
        }
        if (v==forgot_password){
            Intent intent= new Intent(LogInActivity.this,MainActivity.class);
            startActivity(intent);

        }
    }
}
