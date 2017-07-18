package com.app.herballifemvp.detailcatalog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.herballifemvp.R;
import com.app.herballifemvp.data.Catalog;

/**
 * Created by Taufik on 07/17/17.
 */

public class DetailCatalogActivity extends AppCompatActivity implements DetailCatalogContract.View{

    DetailCatalogContract.Presenter presenter;
    TextView nama;
    TextView guna;
    ImageView gambar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new DetailCatalogPresenter(this,this);

        setContentView(R.layout.detail_katalog);

        nama = (TextView)findViewById(R.id.nama_tumbuhan);
        guna = (TextView)findViewById(R.id.kegunaan);
        gambar = (ImageView)findViewById(R.id.gambar);
        presenter.getDetail( getIntent().getStringExtra("kirim_tumbuhan") );
    }

//
//    @Override
//    public void setPresenter(DetailCatalogContract.Presenter presenter) {
//        this.presenter = presenter;
//    }

    @Override
    public void setDetail(Catalog data) {
        nama.setText( data.getNama() );
        guna.setText(data.getGuna());
        gambar.setImageBitmap( data.getBlobImage() );
    }

    @Override
    public void setErrorMessage(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }
}
