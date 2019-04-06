package com.example.doancuoiky.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.doancuoiky.Model.Table;

import java.util.List;
import java.util.zip.Inflater;

public class TableAdapter extends BaseAdapter {
    Context mContext;
    int mResource;
    List<Table> arrProduct;
    @Override
    public int getCount() {
        return arrProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return arrProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mResource,null);

        return convertView;
    }
}
