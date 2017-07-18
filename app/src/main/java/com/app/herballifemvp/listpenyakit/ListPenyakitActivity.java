package com.app.herballifemvp.listpenyakit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.app.herballifemvp.DetailPenyakit.DetailPenyakitActivity;
import com.app.herballifemvp.R;

/**
 * Created by Taufik on 07/17/17.
 */

public class ListPenyakitActivity extends AppCompatActivity implements ListPenyakitContract.View {

    TextView selection;
    AutoCompleteTextView edit;
    ListPenyakitContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cari_penyakit);

        selection = (TextView) findViewById(R.id.selection);
        edit = (AutoCompleteTextView) findViewById(R.id.edit);
        presenter = new ListPenyakitPresenter(this);

        edit.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                navigateToDetailPenyakit( (String)edit.getAdapter().getItem(position) );
            }
        });

    }

    @Override
    public void setItem(String[] data) {
        edit.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,data));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onStart();
    }

    @Override
    public void navigateToDetailPenyakit(String data) {
        Intent tambah = new Intent(this, DetailPenyakitActivity.class);
        tambah.putExtra("kirim_penyakit", data);
        startActivity(tambah);
    }
}
