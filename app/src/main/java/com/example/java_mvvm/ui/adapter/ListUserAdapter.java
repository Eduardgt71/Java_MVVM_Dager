package com.example.java_mvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.java_mvvm.R;
import com.example.java_mvvm.core.model.response.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    private List<User> userList = new ArrayList<>();
    private OnItemlick onItemlick;

    public ListUserAdapter(List<User> userList,  OnItemlick onItemlick) {
        this.userList = userList;
        this.onItemlick = onItemlick;
    }

    public void notifyList(List<User> userList) {
        userList.addAll(userList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Picasso.with(mContext).load(userList.get(position).getAvatar_url())
//                .into(holder.imgAvatar);
        holder.tvId.setText(String.valueOf(userList.get(position).getId()));
        holder.tvLogin.setText(userList.get(position).getLogin());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvId, tvLogin;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.img_avatar);
            tvId = (TextView) itemView.findViewById(R.id.tv_id);
            tvLogin = (TextView) itemView.findViewById(R.id.tv_login);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemlick.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return userList.size() > 0 ? userList.size() : 0;
    }
}