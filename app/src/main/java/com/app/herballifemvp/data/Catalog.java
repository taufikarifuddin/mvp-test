package com.app.herballifemvp.data;

import android.graphics.Bitmap;

/**
 * Created by Taufik on 07/17/17.
 */

public class Catalog {

    private String nama,guna;
    Bitmap blobImage;

    public void setBlobImage(Bitmap blobImage) {
        this.blobImage = blobImage;
    }

    public Bitmap getBlobImage() {
        return blobImage;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGuna() {
        return guna;
    }

    public void setGuna(String guna) {
        this.guna = guna;
    }

}
