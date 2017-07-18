package com.app.herballifemvp.data.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.app.herballifemvp.data.Catalog;
import com.app.herballifemvp.util.SQLiteDBHelper;

import java.util.ArrayList;

/**
 * Created by Taufik on 07/17/17.
 */

public class CatalogRepository {

    SQLiteDBHelper helper;
    SQLiteDatabase db;
    public CatalogRepository(Context ctx){
        helper = new SQLiteDBHelper(ctx);
        db = helper.getDb();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> listitem1 = new ArrayList<>();
        String sql = "select * from Katalog";
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext())
        {
            int index = c.getColumnIndex("Nama");
            String temp = c.getString(index);
            listitem1.add(temp);
        }

        return listitem1;
    }

    public Catalog getDetail(String name){

        Log.d("name",name);
        String sql = "select * from Katalog where Nama ='"+name+"'";
        Cursor c = db.rawQuery(sql, null);

        if( c != null  && c.moveToFirst()){
            Catalog catalog = new Catalog();
            int indexKegunaan = c.getColumnIndex("Kegunaan");
            int indexGambar = c.getColumnIndex("Gambar");

            catalog.setNama(name);
            catalog.setGuna( c.getString(indexKegunaan) );

            byte[] image_byte = c.getBlob( indexGambar );
            Bitmap image = BitmapFactory.decodeByteArray(image_byte, 0, image_byte.length);
            catalog.setBlobImage( image );

            return catalog;
        }else{
            Log.d("null","null reference");
            Log.d("null",sql);
            return null;
        }

    }

}
