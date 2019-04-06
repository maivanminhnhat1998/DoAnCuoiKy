package com.example.doancuoiky;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.doancuoiky.Adapter.DanhSachAdapter;
import com.example.doancuoiky.Database.MySQLite;
import com.example.doancuoiky.Model.Product;

import java.util.ArrayList;
import java.util.List;


public class DanhSachSP extends Fragment {
    ListView lv_sp;
    ImageView img_add_sp;
    List<Product> productList;
    MySQLite mySQLite;
    public DanhSachSP() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_sach, container, false);
        lv_sp = (ListView)view.findViewById(R.id.listview_ds);
        img_add_sp = (ImageView) view.findViewById(R.id.img_add_sp);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        lv_sp = getActivity().findViewById(R.id.listview_ds);
        mySQLite = new MySQLite(getContext());
        mySQLite.OpenDB();
        productList= mySQLite.getAll();
        if (productList.size() < 1 ){
            Product item = new Product(1,"Tra Sua","42.000đ");
            mySQLite.addItem(item);
            productList.addAll(mySQLite.getAll());
        }
        DanhSachAdapter adapter = new DanhSachAdapter(getContext(),R.layout.row_ds_sp,productList);
        lv_sp.setAdapter(adapter);
        lv_sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) lv_sp.getItemAtPosition(position);
                Intent intent = new Intent(getContext(),DetailProduct.class);
                intent.putExtra("getProduct",product);
                startActivity(intent);
            }
        });

        img_add_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AddSanPham.class);
                startActivity(intent);

            }
        });
    }
}
