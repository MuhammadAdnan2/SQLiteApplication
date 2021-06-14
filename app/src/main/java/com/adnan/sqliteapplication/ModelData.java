package com.adnan.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;

import static com.adnan.sqliteapplication.Sqlitehelper.*;

public class ModelData {
    String name;
    String father_name;

    public ModelData() {
    }

    public ModelData(String name, String father_name) {
        this.name = name;
        this.father_name = father_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public ContentValues getValues(){
        ContentValues values = new ContentValues(2);
        values.put(Sqlitehelper.Student_Name, this.name);
        values.put(Sqlitehelper.Students_Father, this.father_name);

        return  values;


    }

    @Override
    public String toString() {
        return
                "name= " + name +
                ", father_name= " + father_name +
                "\n";
    }
}
