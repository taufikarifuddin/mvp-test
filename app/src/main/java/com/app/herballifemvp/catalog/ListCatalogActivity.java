package com.app.herballifemvp.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.herballifemvp.R;
import com.app.herballifemvp.detailcatalog.DetailCatalogActivity;

import java.util.ArrayList;

/**
 * Created by Taufik on 07/17/17.
 */

public class ListCatalogActivity extends AppCompatActivity implements ListCatalogContract.View{

    ArrayAdapter<String> adapter;
    ListCatalogContract.Presenter presenter;
    public ListView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_katalog);

        presenter = new ListCatalogPresenter(this,this.getBaseContext());

        list = (ListView) findViewById(R.id.list_tumbuhan);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                navigateToDetailCatalog(adapter.getItem(position));
            }
        });
    }
//
//    @Override
//    public void setPresenter(ListCatalogContract.Presenter presenter) {
//        this.presenter = presenter;
//    }

    @Override
    public void setItem(ArrayList<String> data) {
        if( adapter == null ){
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        }
        list.setAdapter(adapter);
    }

    @Override
    public void navigateToDetailCatalog(String tumbuhan) {
        Intent tambah = new Intent(this, DetailCatalogActivity.class);
        tambah.putExtra("kirim_tumbuhan",tumbuhan);
        startActivity(tambah);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.presenter.onStart();
    }
}
