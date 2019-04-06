package com.example.doancuoiky.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.doancuoiky.Model.Table;
import com.example.doancuoiky.R;

import java.util.List;

public class DanhSachBanAdapter extends BaseAdapter {
    private Context mContext;
    private int mResuorce;
    private List<Table> tables;

    public DanhSachBanAdapter(Context mContext, int mResuorce, List<Table> tables) {
        this.mContext = mContext;
        this.mResuorce = mResuorce;
        this.tables = tables;
    }

    @Override
    public int getCount() {
        return tables.size();
    }

    @Override
    public Object getItem(int position) {
        return tables.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mResuorce,null);

         TextView tv_ds_table = (TextView)convertView.findViewById(R.id.tv_ds_table);

         final Table table = tables.get(position);
         tv_ds_table.setText(String.valueOf(table.getNameTable()));
        return convertView;
    }
}
