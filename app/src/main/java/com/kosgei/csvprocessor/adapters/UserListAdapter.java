package com.kosgei.csvprocessor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kosgei.csvprocessor.R;
import com.kosgei.csvprocessor.models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder>  {
    private List<User> mUsers= new ArrayList<>();
    private Context MContext;
    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");

    public  UserListAdapter(List<User> users, Context context)
    {
        mUsers= users;
        MContext= context;
    }


    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.bindUser(mUsers.get(position));

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class UserListViewHolder extends RecyclerView.ViewHolder{
        private TextView name, dob,height,role,status;
        

        public UserListViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            dob = itemView.findViewById(R.id.dob);
            height = itemView.findViewById(R.id.height);
            role = itemView.findViewById(R.id.role);
            status = itemView.findViewById(R.id.status);

        }

        public void bindUser(User user)
        {
            name.setText(user.getFullNames());
            dob.setText(dt1.format(user.getDateOfBirth()));
            height.setText(String.valueOf(user.getHeight()));
            role.setText(listToString(user.getRoles()));
            status.setText(String.valueOf(user.isActive()));
        }

        public String listToString(List<String> stringList)
        {
            String result="";

            for (String s: stringList)
            {
                result += s;
            }
            return  result;
        }
    }
}
