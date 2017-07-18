package com.app.herballifemvp.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.herballifemvp.R;
import com.app.herballifemvp.catalog.ListCatalogActivity;
import com.app.herballifemvp.listpenyakit.ListPenyakitActivity;

public class MainActivity extends AppCompatActivity implements HomeContract.View,View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View searchButton = findViewById(R.id.btn_search);
        searchButton.setOnClickListener(this);
        View catalogButton = findViewById(R.id.btn_catalog);
        catalogButton.setOnClickListener(this);
        View helpButton = findViewById(R.id.btn_help);
        helpButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.btn_exit);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_search:
                navigateToSearch();
                break;
            case R.id.btn_catalog:
                navigateToCatalog();
                break;
            case R.id.btn_help:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("             Herbal Life  \n\n"
                        + "Herbal Life adalah \n"
                        + "aplikasi berbasis android \n"
                        + "yang berisi cara pengobatan penyakit\n"
                        + "terutama menggunakan tumbuhan herbal\n\n"
                        + "Menu Search:\n"
                        + "Digunakan untuk mencari jenis \n"
                        + "penyakit sesuai dengan keyword yang dimasukkan\n\n"
                        + "Menu Katalog:\n"
                        + "Berisi seluruh daftar tumbuhan \n"
                        + "yang bisa digunakan sebagai obat\n\n"
                        + "Application Name :\n\n"
                        + "Herbal Life v1.0.0\n\n" + "Developed By : \n\n"
                        + "Nama : Fajar Teguh \n"
                        + "Nrp    : 2103121006 \n"
                        + "Nama : Abdurachman Rizal    \n"
                        + "Nrp    : 2103121007 \n"
                        + "Nama : Moch Fajar Ramadhan \n"
                        + "Nrp    : 2103121027\n\n")
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog,int id)
                            {
                                dialog.cancel();
                            }
                        });
                AlertDialog judul = builder.create();
                judul.setIcon(R.drawable.help);
                judul.setTitle("Help");
                judul.show();
                break;
            case R.id.btn_exit:
               showExitDialog();
        }
    }

    @Override
    public void navigateToSearch() {
        naviagetToActivity(new Intent(this,ListPenyakitActivity.class));
    }

    @Override
    public void navigateToCatalog() {
        naviagetToActivity(new Intent(this,ListCatalogActivity.class));
    }

    @Override
    public void naviagetToHelp() {
        naviagetToActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void navigateToExit() {
        this.finish();
    }

    @Override
    public void showExitDialog() {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage("Apakah anda benar-benar ingin keluar?")
                .setCancelable(false)
                .setPositiveButton("Tidak",new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog,int id)
                    {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Ya",new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog,int id)
                    {
                        navigateToExit();
                    }
                });
        builder2.create().show();
    }

    @Override
    public void naviagetToActivity(Intent intent) {
        startActivity(intent);
    }


}
