package com.example.doancuoiky.Model;

import java.io.Serializable;
import java.util.List;

public class Table implements Serializable {
    private int Id;
    private String NameTable;

    public Table(int id, String nameTable) {
        Id = id;
        NameTable = nameTable;
    }

    public Table() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameTable() {
        return NameTable;
    }

    public void setNameTable(String nameTable) {
        NameTable = nameTable;
    }

}
