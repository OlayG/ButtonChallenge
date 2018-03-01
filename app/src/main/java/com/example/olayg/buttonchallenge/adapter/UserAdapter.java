package com.example.olayg.buttonchallenge.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.olayg.buttonchallenge.R;
import com.example.olayg.buttonchallenge.data.entities.User;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

/**
 * Created by olayg on 2/28/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserAdapterViewHolder(view);
    }

    @DebugLog
    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {
        User user = users.get(position);

        holder.tvUserFullName.setText(user.getName());

        holder.ivUserImage.setBackgroundColor(getRandomColor());
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public long getItemId(int position) {
        return ((users != null) && (users.size() != 0) ? users.size() : 0);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void loadNewData(List<User> newUsers) {
        users = newUsers;
        notifyDataSetChanged();
    }

    static class UserAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUserFullName)
        TextView tvUserFullName;
        @BindView(R.id.ivUserImage)
        ImageView ivUserImage;
        public UserAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
