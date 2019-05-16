package com.example.tokenapp.project.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tokenapp.R;
import com.example.tokenapp.project.modal.User;

public class CommuncationAdapter extends RecyclerView.Adapter<CommuncationAdapter.ViewHolder> {
    User[] user;
    public CommuncationAdapter(User[] user) {
        this.user=user;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View listitem=inflater.inflate(R.layout.user_dummy_list_item,viewGroup,false);
        ViewHolder viewHolder= new ViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final User userProfile= user[i];

        viewHolder.name.setText(user[i].getName());
        viewHolder.email.setText(user[i].getEmail());
        viewHolder.phone.setText(String.valueOf(user[i].getPhone()));
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Hi "+ userProfile.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return user.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name=itemView.findViewById(R.id.textView);
            this.email=itemView.findViewById(R.id.textView2);
            this.phone=itemView.findViewById(R.id.textView3);
            relativeLayout=itemView.findViewById(R.id.userRelativeLayout);
        }
    }
}
