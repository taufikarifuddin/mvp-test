package com.app.herballifemvp.data;

/**
 * Created by Taufik on 07/17/17.
 */

public class Penyakit {

    String bahan,cara,name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public void setCara(String cara) {
        this.cara = cara;
    }

    public String getBahan() {
        return bahan;
    }

    public String getCara() {
        return cara;
    }
}
