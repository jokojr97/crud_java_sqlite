package com.example.sqliteapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    static MyDB myDB;
    ArrayList<String>arrayListNama;
    ArrayList<Integer>arrayListNRP;
    ListView listView;
    Button buttonTambah;
    ArrayList<String>arrayListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fungsiTambahData(View view) {
    }
}
