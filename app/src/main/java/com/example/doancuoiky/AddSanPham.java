package com.example.doancuoiky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doancuoiky.Database.MySQLite;
import com.example.doancuoiky.Model.Product;

import org.w3c.dom.CharacterData;

import java.util.ArrayList;
import java.util.List;

public class AddSanPham extends AppCompatActivity {

    Button btn_add_sp,btn_cancel;
    EditText edt_ten_sp,edt_gia_sp;
    MySQLite mySQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_san_pham);

        onInit();
        AddData();
    }

    private void onInit() {
        btn_add_sp = (Button)findViewById(R.id.btn_add_sp);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        edt_ten_sp = (EditText)findViewById(R.id.edt_ten_sp);
        edt_gia_sp = (EditText)findViewById(R.id.edt_gia_sp);
    }

    public  void AddData() {
        btn_add_sp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     if (onValuedateForm()){
                         mySQLite = new MySQLite(AddSanPham.this);
                         mySQLite.OpenDB();
                         Product item = new Product(edt_ten_sp.getText().toString(),edt_gia_sp.getText().toString());
//                         mySQLite.InsertDUBLE(edt_ten_sp.getText().toString(),edt_gia_sp.getText().toString());
                         List<Product> arrlist = new ArrayList<>();
                         arrlist.addAll(mySQLite.getAll());
//                         boolean check = false;
//
//                         for (int i= 0; i<arrlist.size();i++){
//                             if (edt_ten_sp.getText().toString().equals(arrlist.get(i).getProductName())){
//                                check = true;
//                                return;
//                             }
//                         }
//                         if(check== false){
                             mySQLite.addItem(item);
                             finish();
//                         }
//                         else {
//                             Toast.makeText(AddSanPham.this,"Ten San Pham Da Ton Tai",Toast.LENGTH_LONG).show();
//                         }
//
                     }
                  }
                }
        );
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private boolean onValuedateForm(){
        String errorText = "This field cannot be blank";
        String edtName="";
        String edtPrice="";

        edtName = edt_ten_sp.getText().toString();
        edtPrice = edt_gia_sp.getText().toString();
        if (edtName.length()<1){
            edt_ten_sp.setError(errorText);
            return false;
        }
        if (edtPrice.length()<1){
            edt_gia_sp.setError(errorText);
            return false;
        }
        return true;
    }
}
