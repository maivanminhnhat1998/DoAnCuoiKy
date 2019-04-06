package com.example.doancuoiky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.doancuoiky.Model.Product;

public class DetailProduct extends AppCompatActivity {
    TextView tv_Detail_Name,tv_Detail_Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        onInit();
        onGetInten();
    }

    private void onGetInten() {
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("getProduct");
        tv_Detail_Name.setText(String.valueOf(product.getProductName()));
        tv_Detail_Price.setText(String.valueOf(product.getProductPrice()));
    }

    private void onInit() {
        tv_Detail_Name = (TextView)findViewById(R.id.tv_Detail_Name);
        tv_Detail_Price = (TextView)findViewById(R.id.tv_Detail_Price);
    }
}
