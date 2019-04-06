package com.example.doancuoiky;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.doancuoiky.Adapter.DanhSachBanAdapter;
import com.example.doancuoiky.Database.MySQLite;
import com.example.doancuoiky.Model.Table;

import java.util.ArrayList;
import java.util.List;


public class DanhSachBan extends Fragment {
    ListView lv_table;
    Button btn_add_ds_ban;
    List<Table> tableList;
    MySQLite sqLite;

    public DanhSachBan() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_sach_ban, container, false);

        lv_table =(ListView)view.findViewById(R.id.lv_table);
        btn_add_ds_ban=(Button)view.findViewById(R.id.btn_add_ds_ban);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
//        tableList= new ArrayList<>();
//        tableList.add(new Table(1,"BAN 1"));
//        tableList.add(new Table(2,"BAN 2"));
//        tableList.add(new Table(3,"BAN 3"));
//        tableList.add(new Table(4,"BAN 4"));
//        tableList.add(new Table(5,"BAN 5"));
//        tableList.add(new Table(6,"BAN 6"));
//        tableList.add(new Table(7,"BAN 7"));


        sqLite = new MySQLite(getContext());
        sqLite.OpenDB();
        tableList = sqLite.getAllTable();
        if (tableList.size() < 1 ){
            Table item = new Table(1,"BAN 1");
            Table item1 = new Table(2,"BAN 2");
            Table item2 = new Table(3,"BAN 3");

            sqLite.addItemTable(item);
            sqLite.addItemTable(item1);
            sqLite.addItemTable(item2);
            tableList.addAll(sqLite.getAllTable());
        }
        DanhSachBanAdapter danhSachBanAdapter = new DanhSachBanAdapter(getContext(),R.layout.row_ds_ban,tableList);
        lv_table.setAdapter(danhSachBanAdapter);
        btn_add_ds_ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CreateTable.class);
                startActivity(intent);
            }
        });
    }
}
