package com.app.herballifemvp.detailcatalog;

import android.content.Context;

import com.app.herballifemvp.data.Catalog;
import com.app.herballifemvp.data.storage.CatalogRepository;

/**
 * Created by Taufik on 07/17/17.
 */

public class DetailCatalogPresenter implements DetailCatalogContract.Presenter {

    DetailCatalogContract.View view;
    CatalogRepository repository;

    public DetailCatalogPresenter(DetailCatalogContract.View view, Context ctx){
        this.view = view;
        repository = new CatalogRepository(ctx);
    }

    @Override
    public void onStart() {
    }

    @Override
    public void getDetail(String name) {
        Catalog catalog =repository.getDetail(name);
        if( catalog != null ) {
            view.setDetail(catalog);
        }else{
            view.setErrorMessage("Detail Katalog yang memiliki name : "+name+" tidak ditemkan");
        }


    }
}
