package com.example.dark_mode.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dark_mode.R;

public class ListAdapter extends BaseAdapter {

    Context context;
    int[] image;
    LayoutInflater inflater;

    public ListAdapter(Context context,int[] image) {
        this.context=context;
        this.image=image;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.custom_list, null);
        ImageView img = convertView.findViewById(R.id.imageView6);
        img.setImageResource(image[position]);
        return convertView;
    }
}
