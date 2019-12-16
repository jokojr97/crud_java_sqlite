package com.example.sqliteapp_java;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDB implements SQLiteOpenHelper {
    Context mContext;
    public static String DATABASE_NAME = "mahasiswa";
    public static int VERSION = 1;

    public MyDB(Context context) {
        super(context,
                DATABASE_NAME,
                null,
                VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String sql = "create table biodata (nrp integer primary key,"+"nama text, alamat text);";
            db.execSQL(sql);
            Toast.makeText(mContext, "table Created Successgull",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.e("error", "Table Creation Error");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Menambah record pada tabel mahasiswa
    public boolean insertData(int nrp, String nama, String alamat){
        try {
            String sql = "insert into biodata values ("+nrp+", '"+nama+"', '"+alamat+"')";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }
}
