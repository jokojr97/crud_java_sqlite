package com.example.sqliteapp_java;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDB extends SQLiteOpenHelper {
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

    //menampilkan record pada tabel mahasiswa by nrp
    public Cursor tampilDataMahasiswa(String nrp){
        try {
            String sql = "select * from biodata where nrp="+nrp+";";
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            return cursor;
        }catch (Exception e){
            return null;
        }
    }

    //menampilkan record pada tabel mahasiswa
    public Cursor tampilSemuaDataMahasiswa(String nrp){
        try {
            String sql = "select * from biodata;";
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            return cursor;
        }catch (Exception e){
            return null;
        }
    }

    //Mengupdate record pada tabel mahasiswa
    public boolean updateData(int nrpLama, int nrpBaru, String nama, String alamat){
        try {
            String sql = "update biodata set" +
                    " nrp="+nrpBaru+", nama='"+nama+"', alamat='"+alamat+"' where nrp="+nrpLama+";";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int nrpLama){
        try {
            String sql = "delete from biodata where nrp="+nrpLama+";";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

}
