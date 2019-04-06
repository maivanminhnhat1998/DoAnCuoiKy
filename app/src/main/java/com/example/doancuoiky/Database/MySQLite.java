package com.example.doancuoiky.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import com.example.doancuoiky.Model.Product;
import com.example.doancuoiky.Model.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySQLite extends SQLiteOpenHelper {
    public static final String DBName = "SQLite_demo";
    public static final int VERSION=1;

    //Table Product
    public static final String TABLE_Product = "Product";
    public static final String Product_Id = "Id";
    public static final String Product_Name = "ProductName";
    public static final String Product_Price= "ProductPrice";
    //Table Ban`
    public static final String TABLE_Table ="Ban";
    public static final String Table_Id ="Id";
    public static final String Table_NameTable="NameTable";


    public SQLiteDatabase mDB;
    public MySQLite(Context context) {
        super(context, DBName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String mQuery = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT, %s TEXT)",
        TABLE_Product,Product_Id,Product_Name,Product_Price);
       String mQueryTable = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT)",
                TABLE_Table,Table_Id,Table_NameTable);
        db.execSQL(mQuery);
        db.execSQL(mQueryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void OpenDB(){
        mDB = getWritableDatabase();
    }

    public void CloseDB(){
        if ( mDB != null ){
            mDB.close();
        }
    }
    public List<Product> getAll(){
        List<Product> productList = new ArrayList<>();
        String mQuery = String.format("SELECT * FROM %s",TABLE_Product);
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Product item = new Product();
                item.setProductName(cursor.getString(cursor.getColumnIndex(Product_Name)));
                item.setProductPrice(cursor.getString(cursor.getColumnIndex(Product_Price)));
                productList.add(item);
            }
            cursor.close();
        }
        return productList;
    }
    public void addItem(Product item){
        ContentValues values = new ContentValues();
        values.put(Product_Name,item.getProductName());
        values.put(Product_Price,item.getProductPrice());
        mDB.insert(TABLE_Product,null,values);
    }
//    public void InsertDUBLE(String product_Name, String product_Price){
//        String mQuery = String.format("IF NOT EXISTS(SELECT TOP 1 ID FROM %s WHERE %s LIKE %s)BEGIN INSERT INTO %s VALUES(%s,%s)END",
//                                                    TABLE_Product,Product_Name,product_Name,TABLE_Product,product_Name,product_Price);
//        Cursor cursor= mDB.rawQuery(mQuery,null);
//
//
//
//    }
    public List<Table> getAllTable(){
        List<Table> tableList = new ArrayList<>();
        String mQuery = String.format("SELECT * FROM %s",TABLE_Table);
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Table item = new Table();
                item.setId(cursor.getInt(cursor.getColumnIndex(Table_Id)));
                item.setNameTable(cursor.getString(cursor.getColumnIndex(Table_NameTable)));

                tableList.add(item);
            }
         cursor.close();
        }
        return tableList;
    }
    public void addItemTable(Table item){
        ContentValues values = new ContentValues();
        values.put(Table_NameTable,item.getNameTable());
        mDB.insert(TABLE_Table,null,values);
    }

}
