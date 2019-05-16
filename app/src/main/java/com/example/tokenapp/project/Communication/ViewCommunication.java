package com.example.tokenapp.project.Communication;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;


import com.example.tokenapp.R;
import com.example.tokenapp.project.Adapters.CommuncationAdapter;
import com.example.tokenapp.project.modal.User;

public class ViewCommunication extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    RecyclerView recyclerView;
    CommuncationAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_communication);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.communication);
        actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        User[] users= new User[]{
                new User("sanika","@gmail",9088),
                new User("sanika","@gmail",9088),
                new User("sanika","@gmail",9088),
                new User("sanika","@gmail",9088),
                new User("sanika","@gmail",9088),
        };
        recyclerView =findViewById(R.id.viewCommunicationRecycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new CommuncationAdapter(users);
        recyclerView.setAdapter(adapter );


    }
}
