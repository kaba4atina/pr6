package com.example.myapp.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapp.data.model.Item;
import com.example.myapp.R;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<Item> {
    private final LayoutInflater inflater;
    private final int layout;
    private final ArrayList<Item> items;
    public ListViewAdapter(Context context, int layout,
                           ArrayList<Item> items) {
        super(context, layout, items);
        this.items = items;
        this.layout = layout;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @SuppressLint("UseCompatLoadingForDrawables")
    public View getView(int position, View convertView,
                        @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view=inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.list_item_text_view);
        ImageView imageView = view.findViewById(R.id.list_item_image_view);
        Item item = items.get(position);
        textView.setText(item.title);
        imageView.setImageDrawable(parent.getContext().getDrawable(item.imageRes));
        return view;
    }
}
