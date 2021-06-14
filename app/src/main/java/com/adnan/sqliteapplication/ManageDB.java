package com.adnan.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.widget.Toast;

import java.util.ArrayList;

public class ManageDB {

     MyDatabase myDatabase;
     Context context;
     SQLiteDatabase sqLiteDatabase;

    public  ManageDB(Context context){
        this.context = context;

        this.myDatabase = new MyDatabase(this.context);

        sqLiteDatabase = myDatabase.getWritableDatabase();


    }

    public  void open(){
        sqLiteDatabase = myDatabase.getWritableDatabase();

    }



    public  void close(){
        sqLiteDatabase.close();

    }
    public void InsertData(ModelData modelData){

       long g = sqLiteDatabase.insert(Sqlitehelper.Table_Name, null, modelData.getValues());

        Toast.makeText(context, "Data Inserted..."+g, Toast.LENGTH_SHORT).show();

    }

    public ArrayList<ModelData> getAllData(){
        ArrayList<ModelData> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.query(Sqlitehelper.Table_Name, Sqlitehelper.ALL_COLUMN, null, null, null, null, null);
         for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            ModelData modelDatas = new ModelData();
            modelDatas.setName(cursor.getString(cursor.getColumnIndex(Sqlitehelper.Student_Name)));
            modelDatas.setFather_name(cursor.getString(cursor.getColumnIndex(Sqlitehelper.Students_Father)));

            arrayList.add(modelDatas);

        }
        cursor.close();
        return  arrayList;

    }

    public  void update(String n, String f){

        ContentValues v = new ContentValues();
        v.put(Sqlitehelper.Student_Name, n);
        String wherec = Sqlitehelper.Students_Father + " LIKE ? ";
        String[] wherearg = {f};

         sqLiteDatabase.update(Sqlitehelper.Table_Name, v, wherec, wherearg);
        Toast.makeText(context, "Data Updated...", Toast.LENGTH_SHORT).show();


    }

    public  void deleteData(String n){

        String whereC = Sqlitehelper.Student_Name + " LIKE ? ";
        String[] wherearg = {n};
        sqLiteDatabase.delete(Sqlitehelper.Table_Name, whereC, wherearg);
        Toast.makeText(context, "Data Deleted....", Toast.LENGTH_SHORT).show();

    }

}
