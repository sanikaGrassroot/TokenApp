package com.example.tokenapp.project.UserManagement;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tokenapp.R;
import com.example.tokenapp.project.Dashboard.MainActivity;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user,password;
    TextView register,forgot_password;
    Button logIn;
    Toolbar toolbar;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        user=findViewById(R.id.email_phone_EditText_LogIn);
        password=findViewById(R.id.password_EditText_LogIn);
        register=findViewById(R.id.registerTextView);
        forgot_password=findViewById(R.id.forgotPasswordTextView);
        logIn=findViewById(R.id.LogInButton);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.login);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();


        register.setOnClickListener(this);
        forgot_password.setOnClickListener(this);
        logIn.setOnClickListener(this);
        // TODO:update the toolbar label
    }

    @Override
    public void onClick(View v) {
        if(v==logIn){
            //TODO: logIn logic to be added
            Intent intent= new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);

        }
        if (v==register){
            Intent intent= new Intent(LogInActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
        if (v==forgot_password){
            //TODO: ask about the implementation of this part
            Intent intent= new Intent(LogInActivity.this,MainActivity.class);
            startActivity(intent);

        }
    }
}
