package com.adnan.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText tvdata;
    EditText tvfather;
    Button btnsave, btnshowdata, btnupdate, btndelete;
    TextView tvdatashow;

    ManageDB manageDB;

    ArrayList<ModelData> arrayLists = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manageDB = new ManageDB(this);
        tvdata = findViewById(R.id.tvdata);
        tvfather = findViewById(R.id.tvfather);

        btnsave = findViewById(R.id.btnsave);
        btnshowdata = findViewById(R.id.btnshowdata);
        tvdatashow = findViewById(R.id.tvdatashow);
        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        arrayLists = manageDB.getAllData();



        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String names = tvdata.getText().toString();
               String father = tvfather.getText().toString();

               ModelData modelData = new ModelData(names, father);
               manageDB.open();
               manageDB.InsertData(modelData);
               manageDB.close();
            }
        });

        btnshowdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageDB.open();
                String result = "";

                for (int i=0; i<arrayLists.size(); i++) {

                    result = result + arrayLists.get(i).toString();
                }
                tvdatashow.setText(result);



                manageDB.close();

            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = tvdata.getText().toString();
                String father = tvfather.getText().toString();
                manageDB.update(names, father);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = tvdata.getText().toString();
                String father = "null";
                manageDB.deleteData(names);
            }
        });










    }

    @Override
    protected void onResume() {
        super.onResume();
        manageDB.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        manageDB.close();
    }
}