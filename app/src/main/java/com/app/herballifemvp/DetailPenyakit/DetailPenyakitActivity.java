package com.app.herballifemvp.DetailPenyakit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.herballifemvp.R;
import com.app.herballifemvp.catalog.ListCatalogActivity;
import com.app.herballifemvp.data.Penyakit;

/**
 * Created by Taufik on 07/17/17.
 */

public class DetailPenyakitActivity extends AppCompatActivity implements DetailPenyakitContract.View{

    DetailPenyakitContract.Presenter presenter;

    TextView nama;
    TextView bahan;
    TextView tutor;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_penyakit);
        nama = (TextView)findViewById(R.id.daftar_penyakit);
        bahan =(TextView)findViewById(R.id.bahan);
        button = (Button)findViewById(R.id.button1);
        tutor = (TextView)findViewById(R.id.tutorial);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCatalog();
            }
        });

        presenter = new DetailPenyakitPresenter(this,this);
    }

    @Override
    public void setDetail(Penyakit data) {
        nama.setText(data.getName());
        bahan.setText(data.getBahan());
        tutor.setText(data.getCara());
    }

    @Override
    public void navigateToCatalog() {
        startActivity( new Intent(this, ListCatalogActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getDetail( getIntent().getStringExtra("kirim_penyakit") );

    }
}
