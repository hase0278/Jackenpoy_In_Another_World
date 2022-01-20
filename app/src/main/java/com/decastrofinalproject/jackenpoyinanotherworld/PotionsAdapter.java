package com.decastrofinalproject.jackenpoyinanotherworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PotionsAdapter extends RecyclerView.Adapter<PotionsAdapter.ViewHolder>{
    int items;

    public PotionsAdapter(int itemSize){
        items = itemSize;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public ImageView life;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.life = view.findViewById(R.id.potionsImg);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.life.setImageResource(R.drawable.revive);
    }

    @Override
    public int getItemCount() {
        return items;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void changeItemSize(int itemSize){
        items = itemSize;
        notifyDataSetChanged();
    }
}

