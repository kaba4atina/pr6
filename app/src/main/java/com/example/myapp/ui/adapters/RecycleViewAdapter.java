package com.example.myapp.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.data.model.Item;
import com.example.myapp.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private ArrayList<Item> data;
    private final Context context;

    public RecycleViewAdapter(ArrayList<Item> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = data.get(position);
        holder.textView.setText(item.title);
        holder.imageView.setImageDrawable(context.getDrawable(R.drawable.baseline_emoji_emotions_24));
        Bundle bundle = new Bundle();
        bundle.putInt("Item", item.id);
        holder.root.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(
                    R.id.action_recycleViewFragment_to_itemDetailsFragment,
                    bundle
            );
        });
    }

    public void setNewData(ArrayList<Item> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ViewGroup root;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.list_item_text_view);
            imageView = itemView.findViewById(R.id.list_item_image_view);
            root = itemView.findViewById(R.id.item_root_container);
        }
    }
}
