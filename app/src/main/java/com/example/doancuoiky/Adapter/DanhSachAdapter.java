package com.example.doancuoiky.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.doancuoiky.Model.Product;
import com.example.doancuoiky.R;

import java.util.List;
import java.util.zip.CheckedOutputStream;

public class DanhSachAdapter extends BaseAdapter {

    private Context mContext;
    private int mResource;
    private List<Product> productList;

    public DanhSachAdapter(Context mContext, int mResource, List<Product> productList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mResource,null);

        TextView tv_Product_name = (TextView)convertView.findViewById(R.id.tv_Product_name);
        TextView tv_Product_price = (TextView)convertView.findViewById(R.id.tv_Product_price);



        final Product product =productList.get(position);
        tv_Product_name.setText(String.valueOf(product.getProductName()));
        tv_Product_price.setText(String.valueOf(product.getProductPrice()));


        return convertView;
    }
}
