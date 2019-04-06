package com.example.doancuoiky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateTable extends AppCompatActivity {
    Spinner spiner;
    EditText edt_create_table;
    Button btn_create_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_table);
        onInit();




    }

    private void onInit() {
        spiner = (Spinner)findViewById(R.id.spn_create_table);
        edt_create_table = (EditText)findViewById(R.id.edt_create_table);
        btn_create_table = (Button)findViewById(R.id.btn_create_table);
    }
}
