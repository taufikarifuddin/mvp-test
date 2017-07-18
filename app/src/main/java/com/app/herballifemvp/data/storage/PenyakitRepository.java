package com.app.herballifemvp.data.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.app.herballifemvp.data.Catalog;
import com.app.herballifemvp.data.Penyakit;
import com.app.herballifemvp.util.SQLiteDBHelper;

import java.util.ArrayList;

/**
 * Created by Taufik on 07/17/17.
 */

public class PenyakitRepository {

    SQLiteDBHelper helper;
    SQLiteDatabase db;

    public PenyakitRepository(Context ctx){
        helper = new SQLiteDBHelper(ctx);
        db = helper.getDb();
    }

    public Penyakit getDetail(String name){

        String sql = "select * from data_penyakit where Nama ='"+name+"'";
        Cursor c = db.rawQuery(sql, null);

        if( c != null  && c.moveToFirst()){

            Penyakit penyakit = new Penyakit();

            int index1 = c.getColumnIndex("BahanObat");
            int index2 = c.getColumnIndex("Tutorial");

            penyakit.setBahan( c.getString(index1) );
            penyakit.setCara( c.getString(index2) );
            penyakit.setName( name );

            return penyakit;
        }else{
            Log.d("null","null reference");
            Log.d("null",sql);
            return null;
        }

    }

}
